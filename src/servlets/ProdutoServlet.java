package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanProduto;
import dao.DaoProduto;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoProduto daoProduto = new DaoProduto();

	public ProdutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			String acao = request.getParameter("acao");

			if ( (acao.equalsIgnoreCase("carregar") || acao.equalsIgnoreCase("deletar"))
					|| (acao.equalsIgnoreCase("editar") || acao.equalsIgnoreCase("limpar"))) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroProduto.jsp");

				switch (acao) {
				case "limpar":
					break;
				case "editar":
					Long id = Long.parseLong(request.getParameter("id"));
					if (id != null && id > 0) {
						BeanProduto pro = new BeanProduto();
						pro = daoProduto.buscarProduto(id);
						request.setAttribute("produto", pro);
					}
					break;
				case "deletar":
					Long id1 = Long.parseLong(request.getParameter("id"));
					daoProduto.excluirProduto(id1);
					break;
				}
				request.setAttribute("lista", daoProduto.listarProduto());
				request.setAttribute("categorias", daoProduto.categorias());
				dispatcher.forward(request, response);
			} else {
				throw new Exception("O parametro ação não foi informado!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher home = request.getRequestDispatcher("cadastroProduto.jsp");
			request.setAttribute("lista", daoProduto.listarProduto());
			request.setAttribute("categorias", daoProduto.categorias());
			home.forward(request, response);
		}

	} // fim do metod GET

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String quantidade = request.getParameter("quantidade");
			String valor = request.getParameter("valor");
			valor = valor.replace("R$", "");
			valor = valor.replaceAll("\\.", "");
			valor = valor.replaceAll("\\,", ".");
			int categoria = Integer.parseInt(request.getParameter("categoria"));

			BeanProduto produto = new BeanProduto();
			produto.setNome(nome);
			produto.setQuantidade(Integer.parseInt(quantidade));
			produto.setValor(Double.parseDouble(valor));
			produto.setCategoria(categoria);

			String codigo = request.getParameter("id");

			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroProduto.jsp");
			if (codigo == "") {
				boolean salvar = daoProduto.validaNomeProduto(produto.getNome());
				if (salvar) {
					request.setAttribute("nome_msg", "Nome já cadastrado!");
					request.setAttribute("produto", produto);
				} else {
					daoProduto.salvarProduto(produto);
					request.setAttribute("alert", "show");
				}

			} else {

				produto.setId(Long.parseLong(codigo));
				boolean nomeExiste = daoProduto.validaNomeProduto(produto.getNome(), produto.getId());
				
				if (nomeExiste) {
					request.setAttribute("nome_msg", "Nome já cadastrado!");
					request.setAttribute("produto", produto);
				} else {
					daoProduto.atualizarProduto(produto);
				}
			}
			request.setAttribute("lista", daoProduto.listarProduto());
			request.setAttribute("categorias", daoProduto.categorias());
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
