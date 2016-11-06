package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Fabricante;
import factory.ConexaoFactory;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getDescricao());
		
		comando.executeUpdate();
	}
	public static void main(String[] args) {
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO 1");
		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
			try {
				fdao.salvar(f1);
				fdao.salvar(f2);
				System.out.println("Salvo com sucesso");
			} catch (SQLException e) {
				System.out.println("N�o salvo....");
				e.printStackTrace();
			}
	}

}