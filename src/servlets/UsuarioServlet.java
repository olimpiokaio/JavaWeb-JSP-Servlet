package servlets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import bean.BeanUsuario;
import dao.DaoUsuario;

@WebServlet("/UsuarioServlet")
@MultipartConfig
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static DaoUsuario daoUsuario = new DaoUsuario();
	/*criamos um objeto para fazer o desloacamento para a nossa pagina
	de cadastro e listagem de usuairos*/
	private static RequestDispatcher dispatcher1;
	private boolean matemFoto;
	private boolean matemCurriculo;
	
	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dispatcher1 = request.getRequestDispatcher("cadastrarUsuario.jsp");
		
		try {
			// recupero a ação passada pela url
			String acao = request.getParameter("acao");
			
			// recupera o id passado pela url
			String id = request.getParameter("id");
			
			// vericar qual ação foi solicitada, e a execulta
			if(acao.equalsIgnoreCase("carregar")){
				
				/* setamos um atributo lista com um array de Usuarios trazidos do banco pelo
				metodo listar existente no DAO de usuario, esse atributo(array de usuarios) vai ser
				interado de dentro da nossa pagina cadastroUsuario.jsp */
				dispatcher1 = request.getRequestDispatcher("cadastrarUsuario.jsp");
				
			}else if(acao.equalsIgnoreCase("deletar")) {
				// execulta a ação de excluir usuario
				if(id != null) {
					//chama o metodo deletar da nossa DAO de usuario
					daoUsuario.deletar(Long.parseLong(id));
				}
			}else if(acao.equalsIgnoreCase("editar")) {
				/*para editar e necessario passar o usuario para preecher a lista dos campos da 
				pagina cadastrarUsuario.jsp, por isso precisamos de um obj usuario para retorna-lo
				com os valores do id requisitado*/
				if(id != null) {
					request.setAttribute("user", daoUsuario.buscar(Long.parseLong(id)));
				}
			}else if(acao.equalsIgnoreCase("download")) {
				Long userId = Long.parseLong(request.getParameter("user"));
				if(userId != null) {
					BeanUsuario user = daoUsuario.buscar(userId);
					if(user.getContentType() == null || user.getContentType() == "") {
						System.out.println("Não foi possivel fazer o download");
					} else {
						
						String extencao = null;
						
						if(request.getParameter("tipo").equalsIgnoreCase("foto")) {							
							extencao = user.getContentType().split("\\/")[1];
						}
						else if(request.getParameter("tipo").equalsIgnoreCase("curriculo")) {
							extencao = user.getCurriculoContentType().split("\\/")[1];
						}
						
						response.setHeader("Content-Disposition", "attachment;filename=arquivo." + extencao);
						
						/*Converte a base64 da imagem do banco para byte[]*/
						byte[] fileBytes = null;
						
						if(request.getParameter("tipo").equalsIgnoreCase("foto")) {							
							fileBytes = new Base64().decodeBase64(user.getFotoBase64());							
						}
						else if(request.getParameter("tipo").equalsIgnoreCase("curriculo")) {
							fileBytes = new Base64().decodeBase64(user.getCurriculoBase64());
						}
						
						/*Coloca os bytes em um objeto de entrada para processar*/
						InputStream is= new ByteArrayInputStream(fileBytes);
						
						/*Inicio da resposta para o navegador*/
						int read = 0;
						byte[] bytes = new byte[1024];
						OutputStream os = response.getOutputStream();
						
						while((read = is.read(bytes)) != -1) {
							os.write(bytes, 0, read);
						}
						os.flush();
						os.close();
						return;
					}
				}
			}
			// retorna a lista de usuarios para a jsp
			request.setAttribute("lista", daoUsuario.listar());
			// desloco para a pagina cadastroUsuario.jsp
			this.dispatcher1.forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao deletar ou editar");
			e.printStackTrace();
			dispatcher1 = request.getRequestDispatcher("cadastrarUsuario.jsp");
			request.setAttribute("lista", daoUsuario.listar());
			dispatcher1.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			this.matemFoto = true;
			this.matemCurriculo = true;
			String id = request.getParameter("id") != null ? request.getParameter("id") : null;

			BeanUsuario usuario = new BeanUsuario();

			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setNome(request.getParameter("nome"));
			usuario.setCep(request.getParameter("cep"));
			usuario.setRua(request.getParameter("rua"));
			usuario.setBairro(request.getParameter("bairro"));
			usuario.setCidade(request.getParameter("cidade"));
			usuario.setUf(request.getParameter("uf"));
			usuario.setIbge(request.getParameter("ibge"));
			usuario.setSexo(request.getParameter("sexo"));
			usuario.setComedimento(request.getParameter("come") != null ? "ativo" : "inativo");
			usuario.setPerfil(request.getParameter("perfil"));
			Part fotoTesta = request.getPart("foto");
			Part curriculoTesta = request.getPart("curriculo");
			
			if(ServletFileUpload.isMultipartContent(request)) {
			
				// inicio do fileupload foto
				if (fotoTesta.getInputStream().available() > 0) {
					// faz upload de foto
					String fotoBase64 = new Base64().encodeBase64String(converteStremParabyte(fotoTesta.getInputStream()));
					usuario.setFotoBase64(fotoBase64);
					usuario.setContentType(fotoTesta.getContentType());
					fotoTesta.delete();
					
					// Inicio miniatura image
					
					// transforma em um bufferedImage
					byte[] imageByteDecode = new Base64().decodeBase64(fotoBase64);
					BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageByteDecode)); 
					
					// pega o tipo da image
					int type = bufferedImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : bufferedImage.getType();
					
					// Cria image em miniatura
					BufferedImage resizedImage = new BufferedImage(100, 100, type);
					Graphics2D g = resizedImage.createGraphics();
					g.drawImage(bufferedImage, 0, 0, 100, 100, null);
					g.dispose();
					
					// Escrever imagem novamente
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(resizedImage, "png", baos);
					
					String miniaturaBase64 = "data:image/png;base64," + DatatypeConverter.printBase64Binary(baos.toByteArray());
					
					usuario.setFotoBase64miniatura(miniaturaBase64);
					
					// Fim miniatura image
				} else {
					//mantem a foto do atual do bando de dados
					this.matemFoto = false;
				}
				fotoTesta.delete();
				// fim do fileupload foto
					
				// inicio do fileupload foto
				if(curriculoTesta.getInputStream().available() > 0) {
					// faz upload de curriculo
					
					String curriculoBase64 = new Base64().encodeBase64String(converteStremParabyte(curriculoTesta.getInputStream()));
					usuario.setCurriculoBase64(curriculoBase64);
					usuario.setCurriculoContentType(curriculoTesta.getContentType());
					
					curriculoTesta.delete();
					// fim upload de curriculo
				} else {
					//mantem a curriculo do atual do bando de dados
					this.matemCurriculo = false;
				}
				curriculoTesta.delete();
				// fim do fileupload*/
			}	

			if (!id.isEmpty() && id != "") {
				usuario.setId(Long.parseLong(id));
			}

			boolean podesalvar = true;
			
			// inicio do dispatcher
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
			if (usuario.getLogin() == null) {
				request.setAttribute("txt", "Digite seu login!");
				podesalvar = false;
			} else if (usuario.getNome() == null) {
				request.setAttribute("txt2", "Digite seu nome!");
				podesalvar = false;
			} else if(usuario.getSexo() == null) {
				request.setAttribute("txt10", "Informe o sexo!");
			} else if (usuario.getSenha() == null) {
				request.setAttribute("txt3", "Digite sua senha!");
				podesalvar = false;
			} else if (!usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty() 
					&& !usuario.getNome().isEmpty() && !usuario.getSexo().isEmpty()) {

				// no banco foi definido que o id sempre ira iniciar sua contagem de 1 até o
				// finito
				if (!id.isEmpty()) {

					if (DaoUsuario.validaLogin(usuario.getLogin(), usuario.getId())) {
						request.setAttribute("txt", "Este login já é cadastrado, tente outro!");
						podesalvar = false;
					} else {
						daoUsuario.atualizarUsuario(usuario, matemFoto, matemCurriculo);
					}

				} else if (DaoUsuario.validaLogin(usuario.getLogin())) {
					request.setAttribute("txt", "Esse login de usuario já foi cadastrado!");
					podesalvar = false;
				} else {
					daoUsuario.salvarUsuario(usuario);
					request.setAttribute("alert", "show");
				}
			}

			if (!podesalvar) {
				request.setAttribute("user", usuario);
			}

			request.setAttribute("lista", daoUsuario.listar());
			dispatcher.forward(request, response); // inicio do dispatcher

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* Converte a entrada de fluxo de dados da imagem para um array de bytes */
	protected static byte[] converteStremParabyte(InputStream file) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int reads = file.read();
		while (reads != -1) {
			baos.write(reads);
			reads = file.read();
		}
		return baos.toByteArray();
	}

}
