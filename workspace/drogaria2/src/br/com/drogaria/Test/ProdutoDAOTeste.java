package br.com.drogaria.Test;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	
	public void salvar(){
		Produto p = new Produto();
		p.setDescricao("Novalgina com 10 comprimidos");
		p.setPreco(2.45);
		p.setQuantidade(13L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(18L);
		
	}

}
