package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.BeanUsuario;

import connection.SingleConnection;

public class DaoUsuario {

	private static Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConexao();
	}

	public void salvarUsuario(BeanUsuario usuario) {
		try {
			String sql = "insert into usuario (login, senha, nome, cep, rua, bairro, cidade, uf, ibge, fotoBase64,"
					+ " contentType, curriculoBase64, curriculoContentType, fotoBase64miniatura, acesso, sexo, comedimento, perfil) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getNome());
			statement.setString(4, usuario.getCep());
			statement.setString(5, usuario.getRua());
			statement.setString(6, usuario.getBairro());
			statement.setString(7, usuario.getCidade());
			statement.setString(8, usuario.getUf());
			statement.setString(9, usuario.getIbge());
			statement.setString(10, usuario.getFotoBase64());
			statement.setString(11, usuario.getContentType());
			statement.setString(12, usuario.getCurriculoBase64());
			statement.setString(13, usuario.getCurriculoContentType());
			statement.setString(14, usuario.getFotoBase64miniatura());
			statement.setString(15, usuario.getAcesso());
			statement.setString(16, usuario.getSexo());
			statement.setString(17, usuario.getComedimento());
			statement.setString(18, usuario.getPerfil());
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public ArrayList<BeanUsuario> listar(String nome) {
		try {			
			String sql = "select login, senha, id, nome, fotobase64miniatura, fotoBase64, contentType, ";
			sql += "curriculoBase64, curriculoContentType from usuario where nome like ? and acesso = ? order by nome";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, String.format("%s%s%s", "%", nome, "%"));
			stmt.setString(2, "user");
			return resultadoLista(stmt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BeanUsuario> listar() {
		try {
			String sql = "select login, senha, id, nome, fotobase64miniatura, fotoBase64, contentType, "
					+ "curriculoBase64, curriculoContentType from usuario where acesso = ? order by nome";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "user");
			return resultadoLista(statement);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BeanUsuario> resultadoLista(PreparedStatement statement) throws Exception {
		try {			
			ResultSet resultado = statement.executeQuery();
			ArrayList<BeanUsuario> lista = new ArrayList<BeanUsuario>();
			while(resultado.next()) {
				BeanUsuario user = new BeanUsuario();
				user.setLogin(resultado.getString("login"));
				user.setSenha(resultado.getString("senha"));
				user.setId(resultado.getLong("id"));
				user.setNome(resultado.getString("nome"));
				user.setFotoBase64miniatura(resultado.getString("fotoBase64miniatura"));
				user.setFotoBase64(resultado.getString("fotoBase64"));
				user.setContentType(resultado.getString("contentType"));
				user.setCurriculoBase64(resultado.getString("curriculoBase64"));
				user.setCurriculoContentType(resultado.getString("curriculoContentType"));
				lista.add(user);
			}
			lista.trimToSize();
			return lista;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deletar(Long id) {	
		try {
			String sql = "delete from usuario where id = ? and acesso = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setString(2, "user");
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static boolean validaLogin(String login, Long id) {
		try {
			String sql = "select count(*) as qtd from usuario where login = ? and id <> ? and acesso = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setLong(2, id);
			statement.setString(3, "user");
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			
			if(resultado.next()) {
				return resultado.getInt("qtd") > 0 ? true : false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean validaLogin(String login) {
		try {
			String sql = "select count(*) as qtd from usuario where login = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			
			if(resultado.next()) {
				return resultado.getInt("qtd") > 0 ? true : false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static BeanUsuario buscar(Long id) {
		try {
			String sql = "select * from usuario where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			
			BeanUsuario usuario = new BeanUsuario();
			while(resultado.next()) {
				usuario.setId(resultado.getLong("id"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setCep(resultado.getString("cep"));
				usuario.setRua(resultado.getString("rua"));
				usuario.setBairro(resultado.getString("bairro"));
				usuario.setCidade(resultado.getString("cidade"));
				usuario.setUf(resultado.getString("uf"));
				usuario.setIbge(resultado.getString("ibge"));
				usuario.setFotoBase64(resultado.getString("fotoBase64"));
				usuario.setContentType(resultado.getString("contentType"));
				usuario.setFotoBase64miniatura(resultado.getString("fotoBase64miniatura"));
				usuario.setCurriculoBase64(resultado.getString("curriculoBase64"));
				usuario.setCurriculoContentType(resultado.getString("curriculoContentType"));
				usuario.setSexo(resultado.getString("sexo"));
				usuario.setComedimento(resultado.getString("comedimento"));
				usuario.setPerfil(resultado.getString("perfil"));
			}
			resultado.close();
			statement.close();
			return usuario;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarUsuario(BeanUsuario usuario, boolean matemFoto, boolean matemCurriculo) {
		try {
			
			StringBuilder sql = new StringBuilder();
			sql.append("update usuario set login = ?, senha = ?, nome = ?, cep = ?");
			sql.append(", rua = ?, bairro = ?, cidade = ?, uf = ?, ibge = ?");
			sql.append(", acesso = ?, sexo = ?, comedimento = ?, perfil = ? ");
			
			if(matemFoto == true && matemCurriculo == true) {
				sql.append(",fotoBase64 = ?, contentType = ?, fotoBase64miniatura = ?");
				sql.append(",curriculoBase64 = ?, curriculoContentType = ? ");
			} 
			else if(matemFoto == true && matemCurriculo == false) {
				sql.append(",fotoBase64 = ?, contentType = ?, fotoBase64miniatura = ? ");
			}
			else if(matemFoto == false && matemCurriculo == true) {
				sql.append(",curriculoBase64 = ?, curriculoContentType = ? ");
			}
			sql.append(" where id = ?");
			
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getNome());
			statement.setString(4, usuario.getCep());
			statement.setString(5, usuario.getRua());
			statement.setString(6, usuario.getBairro());
			statement.setString(7, usuario.getCidade());
			statement.setString(8, usuario.getUf());
			statement.setString(9, usuario.getIbge());
			statement.setString(10, usuario.getAcesso());
			statement.setString(11, usuario.getSexo());
			statement.setString(12, usuario.getComedimento());
			statement.setString(13, usuario.getPerfil());
			
			if(matemFoto == true && matemCurriculo == true) {
				// foto
				statement.setString(14, usuario.getFotoBase64());
				statement.setString(15, usuario.getContentType());
				statement.setString(16, usuario.getFotoBase64miniatura());
				// curriculo
				statement.setString(17, usuario.getCurriculoBase64());
				statement.setString(18, usuario.getCurriculoContentType());
				statement.setLong(19 , usuario.getId());
			} 
			else if(matemFoto == true && matemCurriculo == false) {
				// foto
				statement.setString(14, usuario.getFotoBase64());
				statement.setString(15, usuario.getContentType());
				statement.setString(16, usuario.getFotoBase64miniatura());
				statement.setLong(17 , usuario.getId());
			}
			else if(matemFoto == false && matemCurriculo == true) {
				// curriculo
				statement.setString(14, usuario.getCurriculoBase64());
				statement.setString(15, usuario.getCurriculoContentType());
				statement.setLong(16 , usuario.getId());
			} else {
				statement.setLong(14 , usuario.getId());
			}
			
			statement.executeUpdate();
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
}





























