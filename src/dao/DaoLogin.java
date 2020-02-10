package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	private static Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConexao();
	}

	public boolean usuarioLogin(String login, String senha) {
		try {
			String sql = "select count(*) as qtd from usuario where login = ? and senha = ? and acesso = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, senha);
			statement.setString(3, "prop");
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			
			resultado.next();
			int qtd = resultado.getInt("qtd");
			if(qtd > 0) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
