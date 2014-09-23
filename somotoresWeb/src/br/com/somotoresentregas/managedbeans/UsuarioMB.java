package br.com.somotoresentregas.managedbeans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.entities.Usuario;

@Named(value="usuarioMB")
@ViewScoped
public class UsuarioMB extends AbstractManagedBean<Usuario>{
	
	private static final long serialVersionUID = 1L;

	public UsuarioMB(){
		super(Usuario.class);
	}
	
	//Artifício para funcionar Ajax
	public void resetParents(){
		
	}
	
}
