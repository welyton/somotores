package br.com.somotoresentregas.managedbeans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.entities.Categoria;

@Named(value="categoriaMB")
@ViewScoped
public class CategoriaMB extends AbstractManagedBean<Categoria>{
	
	private static final long serialVersionUID = 1L;

	public CategoriaMB(){
		super(Categoria.class);
	}
	
	//Artifício para funcionar Ajax
	public void resetParents(){
		
	}
}
