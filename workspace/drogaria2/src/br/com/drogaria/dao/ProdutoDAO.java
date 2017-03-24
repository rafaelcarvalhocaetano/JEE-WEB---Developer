package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
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
	
	public ArrayList<Produto> lista()throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT p.codigo, p.descricao, p.preco, p.quantidade, f.codigo, f.descricao "); 
		sql.append("FROM produto p ");
		sql.append("INNER JOIN fabricante f ON f.codigo = p.fabricante_codigo ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ppt = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = ppt.executeQuery();
		
		ArrayList<Produto> itens = new ArrayList<Produto>();
		
		while(resultado.next()){
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("f.codigo"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			
			Produto p = new Produto();
			p.setCodigo(resultado.getLong("p.codigo"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setPreco(resultado.getDouble("p.preco"));
			p.setQuantidade(resultado.getLong("p.quantidade"));
			
			p.setFabricante(f);
			
			itens.add(p);
		}
		
		return itens;
		
	}
}
