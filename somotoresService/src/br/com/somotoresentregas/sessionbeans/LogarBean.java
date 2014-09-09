package br.com.somotoresentregas.sessionbeans;

import javax.ejb.Stateless;

@Stateless
public class LogarBean {

	public boolean logar(String pLogin, String pSenha) {
		return "admin".equals(pLogin) && "admin".equals(pSenha);
	}
	
}
