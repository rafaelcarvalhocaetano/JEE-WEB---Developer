package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void adicionarMensagemSucesso(String mensagem) {

		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, fm);
	}

	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, fm);
	}

}
