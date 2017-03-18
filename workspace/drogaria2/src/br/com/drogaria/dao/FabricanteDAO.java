package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {

	public void salvar(Fabricante fab) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante (descricao) VALUES (?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fab.getDescricao());

		comando.executeUpdate();

	}

	public void excluir(Fabricante fab) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fab.getCodigo());

		comando.executeUpdate();

	}

	public void editar(Fabricante fab) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append(" WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, fab.getDescricao());
		comando.setLong(2, fab.getCodigo());

		comando.executeUpdate();
	}

	public Fabricante buscarCodigo(Fabricante f) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;
	}

	public ArrayList<Fabricante> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();

			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));

			lista.add(f);
		}

		return lista;

	}

	public static void main(String[] args) {

		/*
		 * -----------SALVAR-------------- Fabricante f1 = new Fabricante();
		 * f1.setDescricao("Descrição 1");
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setDescricao("Descrição 2");
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * fdao.salvar(f1); fdao.salvar(f2); }
		 */
		/*
		 * ----------------DELETE------------------ Fabricante f1 = new
		 * Fabricante(); f1.setCodigo(2L);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(5L);
		 * 
		 * FabricanteDAO dao = new FabricanteDAO();
		 * 
		 * try { dao.excluir(f1); dao.excluir(f2);
		 * System.out.println("Excluidos com sucesso"); } catch (SQLException e)
		 * { System.out.println("Erro de conexão "); e.printStackTrace(); }
		 */
		/*
		 * -------------UPDATE----------------- Fabricante f1 = new
		 * Fabricante();
		 * 
		 * f1.setCodigo(3L); f1.setDescricao("Descrição 3");
		 * 
		 * FabricanteDAO dao = new FabricanteDAO(); try { dao.editar(f1);
		 * System.out.println("Atualizado com sucesso"); } catch (SQLException
		 * e) { System.out.println("ERRO ..."); e.printStackTrace(); }
		 */
		/*
		 * -----------CONSULTAR POR CODIGO---------------------
		 * 
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(3L);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(5L);
		 * 
		 * FabricanteDAO dao = new FabricanteDAO();
		 * 
		 * try { Fabricante f3 = dao.buscarCodigo(f1);
		 * System.out.println("Resultado 1: "+f3); Fabricante f4 =
		 * dao.buscarCodigo(f2); System.out.println("Resultado 2: "+f4);
		 * 
		 * } catch (SQLException e) {
		 * System.out.println("Busca não realizada....."); e.printStackTrace();
		 * }
		 * 
		 */
		FabricanteDAO dao = new FabricanteDAO();
		ArrayList<Fabricante> listar = dao.listar();

	}

}