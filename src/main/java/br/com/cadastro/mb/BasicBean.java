package br.com.cadastro.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public abstract class BasicBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasicBean() {

	}

	

	public void info(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
	}

	public void warn(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null));
	}

	public void error(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public void fatal(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null));
	}

}
