package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.model.ResultSetDataModel;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("value (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getDescricao());
		
		comando.executeUpdate();
		
		
	}
	public void excluir(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		comando.executeUpdate();
	}
	
	public void editar(Fabricante f)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		
		comando.executeUpdate();
	}
	
	public Fabricante buscarPorCodigo(Fabricante f)throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexa = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.preparedStatement(sql.toString());
			
		comando.setLong(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		
		Fabricante retorno = null;
		
		if(resultado.next()){
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		
		/*
		Fabricante f1 = new  Fabricante();
		f1.setDescricao("Descrição 1");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Descrição 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try{
			fdao.salvar(f1);
			System.out.println("Executando..");
		}catch(SQLException ex){
			System.out.println("Not exection..");
			ex.printStackTrace();
		}
		
		
		try{
			fdao.salvar(f2);
			System.out.println("Executando..");
		}catch(SQLException ex){
			System.out.println("Not exection..");
			ex.printStackTrace();
		}
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		try{
		fdao.excluir(f1);
		System.out.println("Connection...");
		}catch(SQLException ex){
			System.out.println("Not Connection...");
		}
		
		try{
		fdao.excluir(f2);
		System.out.println("Connect 2...");
		}catch(SQLException ex){
			System.out.println("Not Connection 2");
		}
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(2L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(3L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.excluir(f1);
			System.out.println("OK....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRO..");
		}
		try {
			fdao.excluir(f2);
			System.out.println("OK....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro...");
		}
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(3L);
		f1.setDescricao("DESCRICAO 3");
		FabricanteDAO fdao = new FabricanteDAO();
		
		try{
			fdao.editar(f1);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("ERRO....");
		}
		*/
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(3L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(5L);
		
		FabricanteDAO = new FabricanteDAO();
		
		try{
			
			Fabricante f3 = fdao.buscaPorCodigo(f1);
			Fabricante f4 = fdao.buscaPorCodigo(f2);
			System.out.println("Correto");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

}
