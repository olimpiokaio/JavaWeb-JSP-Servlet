package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanTelefone;
import bean.BeanUsuario;
import dao.DaoTelefone;
import dao.DaoUsuario;

@WebServlet("/TelefoneServlet")
public class TelefoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoUsuario usuario = new DaoUsuario();
       
    public TelefoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String acao = request.getParameter("acao");
			
			if(acao.equalsIgnoreCase("carregar")) {
				
				Long id = Long.parseLong(request.getParameter("id"));
				
				DaoTelefone telefone = new DaoTelefone();
				
				BeanUsuario user = new BeanUsuario();
				user = DaoUsuario.buscar(id);
				
				RequestDispatcher tela = request.getRequestDispatcher("cadastroTelefone.jsp");
				request.setAttribute("list", telefone.listarTelefone(user.getId()));
				request.setAttribute("user_nome", user.getNome());
				request.setAttribute("user_id", user.getId());
				tela.forward(request, response);
				
			} else if(acao.equalsIgnoreCase("excluir")) {
				
				Long id = Long.parseLong(request.getParameter("id"));
				
				Long idTelefone = Long.parseLong(request.getParameter("tel"));
				
				DaoTelefone telefone = new DaoTelefone();
				telefone.excluirTelefone(id, idTelefone);
				
				BeanUsuario user = new BeanUsuario();
				user = DaoUsuario.buscar(id);
				
				RequestDispatcher tela = request.getRequestDispatcher("cadastroTelefone.jsp");
				request.setAttribute("list", telefone.listarTelefone(user.getId()));
				request.setAttribute("user_nome", user.getNome());
				request.setAttribute("user_id", user.getId());
				tela.forward(request, response);
				
			} else {
				RequestDispatcher tela = request.getRequestDispatcher("login-sucesso.jsp");
				tela.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher home = request.getRequestDispatcher("cadastrarUsuario.jsp");
			request.setAttribute("lista", usuario.listar());
			home.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		String id = request.getParameter("id");
		
		DaoTelefone daoTelefone = new DaoTelefone();
		
		boolean podeSalvar =  daoTelefone.validaNumero(numero, Long.parseLong(id));
		
		BeanUsuario user = new BeanUsuario();
		user = DaoUsuario.buscar(Long.parseLong(id));
		
		BeanTelefone beanTelefone = new BeanTelefone();
		beanTelefone.setNumero(numero);
		beanTelefone.setTipo(tipo);
		beanTelefone.setUsuario(user.getId());
		
		DaoTelefone telefone = new DaoTelefone();
		
		if(!podeSalvar) {
			telefone.salvarTelefone(beanTelefone);
		} else {
			request.setAttribute("numero", beanTelefone.getNumero());
			request.setAttribute("txt1", "Numero já cadastrado. insira um novo numero!");
		}
		
		RequestDispatcher redirect = request.getRequestDispatcher("cadastroTelefone.jsp");
		request.setAttribute("list", telefone.listarTelefone(user.getId()));
		request.setAttribute("user_nome", user.getNome());
		request.setAttribute("user_id", user.getId());
		redirect.forward(request, response);
	}

}
