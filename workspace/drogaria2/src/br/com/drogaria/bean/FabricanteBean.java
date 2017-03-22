package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import org.apache.jasper.compiler.JspUtil;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private ListDataModel<Fabricante> itens;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {

			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void prepararExcluir() {
		fabricante = itens.getRowData();
	}

	public void prepararEditar() {
		fabricante = itens.getRowData();
	}

	public void editar() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
			
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

			ArrayList<Fabricante> listar = dao.listar();
			itens = new ListDataModel<Fabricante>(listar);

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
			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemErro("Fabricante Salvo com Sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
