package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.SingleConnection;
import bean.BeanTelefone;

public class DaoTelefone {
	
	private Connection connection = SingleConnection.getConexao();
	
	// metodo para salvar telefone
	public void salvarTelefone(BeanTelefone telefone) {
		try {
			String sql = "insert into telefone(numero, tipo, usuario) values"
					+ "(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			statement.execute();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// metodo para listar telefones
	public ArrayList<BeanTelefone> listarTelefone(Long id) {
		try {
			String sql = "SELECT * FROM telefone WHERE usuario = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			
			ArrayList<BeanTelefone> lista = new ArrayList<BeanTelefone>();
			
			while(resultado.next()) {
				
				BeanTelefone tel = new BeanTelefone();
				
				tel.setId(resultado.getLong("id"));
				tel.setNumero(resultado.getString("numero"));
				tel.setTipo(resultado.getString("tipo"));
				tel.setUsuario(resultado.getLong("usuario"));
				lista.add(tel);
			}
			
			lista.trimToSize();
			
			if(!lista.isEmpty()) {
				return lista;
			} else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// metodo excluir telefone 29 1
	public void excluirTelefone(Long idUser, Long idTelefone) {
		try {
			String sql = "DELETE FROM telefone WHERE usuario = ? and id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idUser);
			statement.setLong(2, idTelefone);
			statement.execute();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// verifica se o numero já exite no banco de dados
	public boolean validaNumero(String numero, Long id) {
		try {
			String sql = "select * from telefone where numero = ? and usuario = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, numero);
			statement.setLong(2, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			
			if(resultado.next()) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

} // fim da classe Dao Telefone






















