package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.BeanUsuario;
import dao.DaoUsuario;
import java.util.ArrayList;

@WebServlet(description = "ConsultaUsuairo", urlPatterns = { "/ConsultaUsuairo" })
public class ConsultaUsuairo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ConsultaUsuairo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
			String nome = request.getParameter("nome").trim();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");			
			ArrayList<BeanUsuario> user = new ArrayList<BeanUsuario>();
			DaoUsuario daoUsuario = new DaoUsuario();
			
			if(nome != null && nome.length() > 0) {
				
				ArrayList<BeanUsuario> lista = daoUsuario.listar(nome);
				
				if(lista.size() <= 0) {
					request.setAttribute("lista", null);
				} else {
					request.setAttribute("lista", lista);
				}
				
			} else {
				request.setAttribute("lista", daoUsuario.listar());
			}
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}



















