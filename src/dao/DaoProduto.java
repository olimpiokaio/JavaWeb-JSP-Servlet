package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.BeanCategoria;
import bean.BeanProduto;
import connection.SingleConnection;

public class DaoProduto {

	private static Connection connection = SingleConnection.getConexao();

	public void salvarProduto(BeanProduto produto) {
		try {
			String sql = "insert into produto (nome, quantidade, valor, categoria_id) values (?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQuantidade());
			statement.setDouble(3, produto.getValor());
			statement.setInt(4, produto.getCategoria());
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

	public void atualizarProduto(BeanProduto produto) {
		try {
			String sql = " update produto set nome = ?, quantidade = ?, valor = ?, ";
			sql += " categoria_id = ? where id = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQuantidade());
			statement.setDouble(3, produto.getValor());
			statement.setInt(4, produto.getCategoria());
			statement.setLong(5, produto.getId());
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

	public ArrayList<BeanProduto> listarProduto() {
		try {
			String sql = "select * from produto";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			ResultSet resultado = statement.getResultSet();

			ArrayList<BeanProduto> lista = new ArrayList<BeanProduto>();
			while (resultado.next()) {
				BeanProduto pro = new BeanProduto();
				pro.setId(resultado.getLong("id"));
				pro.setNome(resultado.getString("nome"));
				pro.setQuantidade(resultado.getInt("quantidade"));
				pro.setValor(resultado.getDouble("valor"));
				lista.add(pro);
			}
			lista.trimToSize();
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluirProduto(Long id) {
		try {
			String sql = "delete from produto where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
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

	public BeanProduto buscarProduto(Long id) {
		try {
			String sql = "select * from produto where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();

			if (resultado.next()) {
				BeanProduto produto = new BeanProduto();
				produto.setId(resultado.getLong("id"));
				produto.setNome(resultado.getString("nome"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				produto.setValor(resultado.getDouble("valor"));
				produto.setCategoria(resultado.getInt("categoria_id"));
				return produto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// verifia se o nome já está cadastrado no banco com o id diferente do produto
	public boolean validaNomeProduto(String nome, Long id) {
		try {
			String sql = "select * from produto where nome = ? and id <> ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setLong(2, id);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			if (resultado.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public boolean validaNomeProduto(String nome) {
		try {
			String sql = "select * from produto where nome = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.execute();
			ResultSet resultado = statement.getResultSet();
			if (resultado.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<BeanCategoria> categorias() {
		try {
			
			String sql = "select * from categoria";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet res = stmt.getResultSet();
			
			ArrayList<BeanCategoria> cat = new ArrayList<BeanCategoria>();
			
			while(res.next()) {
				BeanCategoria categoria = new BeanCategoria();
				categoria.setId(res.getInt("id"));
				categoria.setNome(res.getString("nome"));
				cat.add(categoria);
			}
			cat.trimToSize();
			
			return cat;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
