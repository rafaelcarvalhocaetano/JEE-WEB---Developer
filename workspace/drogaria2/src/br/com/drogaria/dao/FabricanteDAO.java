package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

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
	public void excluir(Fabricante fab)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("DELETE FROM fabricante WHERE codigo = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, fab.getCodigo());
		
		comando.executeUpdate();
		
		
	}

	public static void main(String[] args) {
	
	/*  -----------SALVAR--------------
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Descrição 1");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Descrição 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		fdao.salvar(f1);
		fdao.salvar(f2);
	}
	*/
		Fabricante f1 = new Fabricante();
		f1.setCodigo(2L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(5L);
		
		FabricanteDAO dao = new FabricanteDAO();
		
		try {
			dao.excluir(f1);
			dao.excluir(f2);
			System.out.println("Excluidos com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro de conexão ");
			e.printStackTrace();
		}
		
	}
	

}
