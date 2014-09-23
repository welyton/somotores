package br.com.somotoresentregas.managedbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.somotoresentregas.sessionbeans.UsuarioBean;

@ManagedBean
@RequestScoped
public class LoginMB {
	private String login;
	private String senha;
	
	@EJB
	private UsuarioBean usuarioService;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logar(){
		if (usuarioService.logarUsuario(login, senha)) {
			return "home";
		} else{
			FacesMessage fm = new FacesMessage("Login ou Senha Inv�lido");
			FacesContext.getCurrentInstance().addMessage("msg", fm);
			return null;
		}
		
	}
}
