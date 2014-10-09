package br.com.somotoresentregas.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.com.somotoresentregas.entities.Usuario;
import br.com.somotoresentregas.sessionbeans.UsuarioBean;
import br.com.somotoresentregas.util.SoMotoresUtil;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public LoginMB(){
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(Usuario pUsuario){
		this.usuario = pUsuario;
	}
	
	@EJB
	private UsuarioBean usuarioService;
	
	public void logar(){
		RequestContext contexto = RequestContext.getCurrentInstance();
		FacesMessage mensagem;
		boolean logado = false;
		String rota = "";
		this.usuario = usuarioService.logarUsuario(this.usuario);
		
		if (this.usuario != null) {
			logado = true;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nomeusuario",this.usuario.getNome());
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ao Só Motores - SGE", this.usuario.getNome());
			rota = SoMotoresUtil.contextoWeb()+"index.xhtml";
		} else{
			logado = false;
			mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Não foi possível Logar", "Usuário e/ou Senha Incorreta");
			this.usuario = new Usuario();
		}
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		contexto.addCallbackParam("logado", logado);
		contexto.addCallbackParam("rota", rota);
	}
}
