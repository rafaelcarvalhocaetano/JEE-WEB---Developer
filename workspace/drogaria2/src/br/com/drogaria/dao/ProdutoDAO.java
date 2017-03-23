package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

public class ProdutoDAO {

	public void salvar(Produto p) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO produto ");
		sql.append("(descricao, quantidade, preco, fabricante_codigo) ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ppt = conexao.prepareStatement(sql.toString());
		
		ppt.setString(1, p.getDescricao());
		ppt.setDouble(2, p.getPreco());
		ppt.setLong(3, p.getQuantidade());
		ppt.setLong(4, p.getFabricante().getCodigo());
		
		ppt.executeUpdate();
	}
}
