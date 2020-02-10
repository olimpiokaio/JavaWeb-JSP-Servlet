package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns={"/*"}) // mapeamento para todas as urls serem interceptadas pelo filter
public class Filter implements javax.servlet.Filter {

	private static Connection connection;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			chain.doFilter(request, response); // filtra as request(requisições do servidor) e response(respostas do servidor)
			connection.commit();
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		javax.servlet.Filter.super.init(filterConfig);

		connection = SingleConnection.getConexao();
	}

}

