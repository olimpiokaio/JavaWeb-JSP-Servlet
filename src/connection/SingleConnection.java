package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String url = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admim";
	private static Connection conexao = null;

	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	public static void conectar() {
		try {
			if (conexao == null) {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, user, password);
				conexao.setAutoCommit(false);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConexao() {
		return conexao;
	}
}