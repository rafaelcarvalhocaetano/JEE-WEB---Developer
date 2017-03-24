package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> itensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}
	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	
	@PostConstruct
	public void prepararPesquisa() {

		try {

			FabricanteDAO dao = new FabricanteDAO();
			itens = dao.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	

	
	public void editar() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			itens = dao.listar();
						
			JSFUtil.adicionarMensagemSucesso("Fabricante editado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();

		try {
			dao.excluir(fabricante);

			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Removido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Salvo com Sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
