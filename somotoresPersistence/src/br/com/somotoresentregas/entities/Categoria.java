package br.com.somotoresentregas.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoriaID;

	private String nome;

	//bi-directional many-to-many association to Produto
	@ManyToMany
	@JoinTable(
		name="categoria_produto"
		, joinColumns={
			@JoinColumn(name="categoriaID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="produtoID")
			}
		)
	private List<Produto> produtos;

	public Categoria() {
	}

	public int getCategoriaID() {
		return this.categoriaID;
	}

	public void setCategoriaID(int categoriaID) {
		this.categoriaID = categoriaID;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}