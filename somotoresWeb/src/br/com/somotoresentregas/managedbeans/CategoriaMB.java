package br.com.somotoresentregas.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.entities.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaMB extends AbstractManagedBean<Categoria>{
	
	private static final long serialVersionUID = 1L;

	public CategoriaMB(){
		super(Categoria.class);
	}
	
	//Artif�cio para funcionar Ajax
	public void resetParents(){
		
	}
}
