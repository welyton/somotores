package br.com.somotoresentregas.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import br.com.somotoresentregas.util.Constantes;
import br.com.somotoresentregas.util.JsfUtil;

public abstract class AbstractManagedBean<T> implements Serializable {
	
	@Inject
	private AbstractEJB<T> ejb;
	private Class<T> item;
	private T selecionado;
	private Collection<T> listaItens;
	private static final long serialVersionUID = 1L;
	
	private enum AcaoPersistencia {
		CREATE,
		DELETE,
		UPDATE
	}
	
	public AbstractManagedBean(){
		
	}
	
	public AbstractManagedBean(Class<T> itemClasse){
		this.item = itemClasse;
	}
	
	public T getSelecionado(){
		return this.selecionado;
	}
	
	public void setSelecionado(T pSelecionado){
		this.selecionado = pSelecionado;
	}

	public Collection<T> getListaItens() {
		if(listaItens == null){
			listaItens = this.ejb.buscaTodos();
		}
		return listaItens;
	}

	public void setListaItens(Collection<T> pListaItens) {
		this.listaItens = pListaItens;
	}
	
	public void atualiza(ActionEvent evento){
		String mensagem = item.getSimpleName() + " " + Constantes.ENTIDADE_ATUALIZADA;
		persiste(AcaoPersistencia.UPDATE,mensagem);
	}
	
	public void insere(ActionEvent evento){
		String mensagem = item.getSimpleName() + " " + Constantes.ENTIDADE_CRIADA;
		persiste(AcaoPersistencia.CREATE,mensagem);
		if(!isValidacaoFalhou()){
			listaItens = null;
		}
	}
	
	public void exclui(ActionEvent evento){
		String mensagem = item.getSimpleName() + " " + Constantes.ENTIDADE_DELETADA;
		persiste(AcaoPersistencia.DELETE,mensagem);
		if(!isValidacaoFalhou()){
			selecionado = null;
			listaItens = null;
		}
	}
	
	private void persiste(AcaoPersistencia acao, String mensagemSucesso){
		if(selecionado != null){
			try{
				if (acao != AcaoPersistencia.DELETE) {
					this.ejb.atualiza(selecionado);
				} else {
					this.ejb.exclui(selecionado);
				}
				JsfUtil.addSuccessMessage(mensagemSucesso);
			} catch (EJBException e) {
				Throwable causa = JsfUtil.getRootCause(e.getCause());
				if(causa != null){
					if(causa instanceof ConstraintViolationException) {
						ConstraintViolationException excecoes = (ConstraintViolationException) causa;
						for (ConstraintViolation s : excecoes.getConstraintViolations()) {
                            JsfUtil.addErrorMessage(s.getMessage());
                        }
					} else {
						String msg = causa.getLocalizedMessage();
						if (msg.length() > 0) {
                            JsfUtil.addErrorMessage(msg);
                        } else {
                            JsfUtil.addErrorMessage(e, Constantes.ERRO_PERSISTENCIA);
                        }
					}
				}
			} catch(Exception e){
				JsfUtil.addErrorMessage(e, Constantes.ERRO_PERSISTENCIA);
			}
		}
	}
	
	public T preparaInsercao(ActionEvent evento){
		T objetoInsercao;
		try{
			objetoInsercao = item.newInstance();
			this.selecionado = objetoInsercao;
			return objetoInsercao;
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public boolean isValidacaoFalhou(){
		return JsfUtil.isValidationFailed();
	}
	
	public String getMensagensByComponent(String componente, String mensagem){
		return JsfUtil.getComponentMessages(componente, mensagem);
	}
	
	@PostConstruct
	public void inicializa(){
		Object parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(this.item.getSimpleName() + "itens");
		if(parametros != null){
			this.listaItens = (Collection<T>) parametros;
		}
	}
	
}
