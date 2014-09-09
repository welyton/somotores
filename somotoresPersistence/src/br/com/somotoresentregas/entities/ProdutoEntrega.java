package br.com.somotoresentregas.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produto_entrega database table.
 * 
 */
@Entity
@Table(name="produto_entrega")
@NamedQuery(name="ProdutoEntrega.findAll", query="SELECT p FROM ProdutoEntrega p")
public class ProdutoEntrega implements Serializable {
	private static final long serialVersionUID = 1L;

	private short produtoQtde;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produtoID")
	private Produto produto;

	//bi-directional many-to-one association to Entrega
	@ManyToOne
	@JoinColumn(name="entregaID")
	private Entrega entrega;

	public ProdutoEntrega() {
	}

	public short getProdutoQtde() {
		return this.produtoQtde;
	}

	public void setProdutoQtde(short produtoQtde) {
		this.produtoQtde = produtoQtde;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Entrega getEntrega() {
		return this.entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

}