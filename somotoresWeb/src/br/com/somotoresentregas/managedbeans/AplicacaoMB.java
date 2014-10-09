package br.com.somotoresentregas.managedbeans;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import br.com.somotoresentregas.util.SoMotoresUtil;

@Named(value="aplicacaoMB")
@ApplicationScoped
public class AplicacaoMB {

	public String getContextoWeb(){
		return SoMotoresUtil.contextoWeb();
	}
	
	public String getContextoMobile(){
		return SoMotoresUtil.contextoMobile();
	}
	
	public String getPathImagem(){
		return SoMotoresUtil.caminhoImagem();
	}
	
	public String getPathCSS(){
		return SoMotoresUtil.caminhoCSS();
	}
	
	public String getPathCategoria(){
		return SoMotoresUtil.caminhoCategoria();
	}
	
	public String getPathProduto(){
		return SoMotoresUtil.caminhoProduto();
	}
	
	public String getPathUsuario(){
		return SoMotoresUtil.caminhoUsuario();
	}
	
	public String getPathLocalizador(){
		return SoMotoresUtil.caminhoLocalizador();
	}
	
}
