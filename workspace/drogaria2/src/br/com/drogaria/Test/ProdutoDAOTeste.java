package br.com.drogaria.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

public class ProdutoDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException {
		Produto p = new Produto();
		p.setDescricao("Novalgina com 10 comprimidos");
		p.setPreco(2.45);
		p.setQuantidade(13L);

		Fabricante f = new Fabricante();
		f.setCodigo(18L);

		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();

		dao.salvar(p);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ProdutoDAO dao = new ProdutoDAO();

		ArrayList<Produto> lista = dao.lista();

		for (Produto p : lista) {

			System.out.println("COdigo dp Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Codigo do Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
			System.out.println();

		}
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Produto p = new Produto();
		p.setCodigo(19L);

		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);

	}
	
	@Test
	public void editar()throws SQLException{
		Produto p = new Produto();
		
		p.setCodigo(5L);
		p.setDescricao("Cataflan Pomada");
		p.setPreco(20.00D);
		p.setQuantidade(20L);
		
		Fabricante f = new Fabricante();
		
		f.setCodigo(18L);
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
		
	}

}
