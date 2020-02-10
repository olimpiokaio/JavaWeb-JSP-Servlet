package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static DaoLogin daoLogin = new DaoLogin();
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("password");
			boolean autentica = false;
			
			RequestDispatcher telaLogin = request.getRequestDispatcher("login-erro.jsp");
			
			if(login.isEmpty()||login==null) {
				telaLogin = request.getRequestDispatcher("index.jsp");
				telaLogin.forward(request, response);
			}
			else if(senha.isEmpty()||senha==null) {
				telaLogin = request.getRequestDispatcher("index.jsp");
				telaLogin.forward(request, response);
			}
			else {
				autentica = daoLogin.usuarioLogin(login, senha);
				telaLogin = request.getRequestDispatcher("login-sucesso.jsp");
				
				if(autentica) {
					telaLogin.forward(request, response);
				} else {
					telaLogin = request.getRequestDispatcher("login-erro.jsp");
					telaLogin.forward(request, response);
				}
			}
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
