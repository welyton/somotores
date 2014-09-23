package br.com.somotoresentregas.managedbeans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.entities.Produto;

@Named(value ="produtoMB")
@ViewScoped
public class ProdutoMB extends AbstractManagedBean<Produto> {
	
	private static final long serialVersionUID = 1L;
	
	public ProdutoMB(){
		super(Produto.class);
	}
	
	//Artifício para funcionar Ajax
	public void resetParents(){
		
	}	
	
}