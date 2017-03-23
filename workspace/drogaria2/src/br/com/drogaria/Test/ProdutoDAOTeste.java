package br.com.drogaria.Test;

import java.sql.SQLException;

import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	
	@Test
	public void salvar() throws SQLException{
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

}
