package com.rcc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "q1w2e3r4";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria";
	
	public static Connection conectar() throws SQLException{
		
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		return connection;
		
	}
	public static void main(String[] args) {
		try {
			Connection connection = ConexaoFactory.conectar();
			System.out.println("Certo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Errado");
		}
	}

}
