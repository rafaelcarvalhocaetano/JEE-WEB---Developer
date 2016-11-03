package br.com.padaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "q1w2e3r4";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/padaria";
	
	public static Connection conectar() throws SQLException{
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
		
	}
	
	public static void main(String [] args){
		
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conectado...");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Not Connection...");
			e.printStackTrace();
		}
	}

}
