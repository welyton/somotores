package br.com.somotoresentregas.mobmanagedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MenuMB {

	public String gotoMinhasEntregas(){
		System.out.println("vai retornar gotominhasentregas");
		return "pm:entrega";
	}
	
	public String gotoRelatorio(){
		System.out.println("vai retornar gotorelatorio");
		return "pm:relatorio";
	}
	
}
