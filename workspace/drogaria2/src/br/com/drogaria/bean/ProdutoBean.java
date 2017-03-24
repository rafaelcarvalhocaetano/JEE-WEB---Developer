package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name="MBProduto")
@ViewScoped
public class ProdutoBean {

	ArrayList<Produto> itens;
	
	public ArrayList<Produto> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	
	
	public void carregarListagem(){
		
		ProdutoDAO dao = new ProdutoDAO();
		
		try {
			itens = dao.lista();
			JSFUtil.adicionarMensagemSucesso("Carregado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
}
