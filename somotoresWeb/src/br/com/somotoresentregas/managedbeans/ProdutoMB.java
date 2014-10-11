package br.com.somotoresentregas.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.entities.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractManagedBean<Produto> {
	
	private static final long serialVersionUID = 1L;
	
	public ProdutoMB(){
		super(Produto.class);
	}
	
	//Artif�cio para funcionar Ajax
	public void resetParents(){
		
	}	
	
}