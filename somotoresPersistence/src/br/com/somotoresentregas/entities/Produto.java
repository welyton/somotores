package br.com.somotoresentregas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
@NamedQueries({
	@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p"),
	@NamedQuery(name="Produto.findById", query="SELECT p FROM Produto p WHERE p.produtoID = :id")})
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int produtoID;

	private String marca;

	private String modelo;

	private String nome;

	private BigDecimal precoUnitario;

	private short sku;

	//bi-directional many-to-many association to Categoria
	@ManyToMany(mappedBy="produtos")
	private List<Categoria> categorias;

	//bi-directional many-to-one association to ProdutoEntrega
	@OneToMany(mappedBy="produto")
	private List<ProdutoEntrega> produtoEntregas;

	public Produto() {
		this.marca = "Marca";
		this.modelo = "Modelo";
		this.nome = "Nome";
		this.sku = 1111;
		this.precoUnitario = new BigDecimal(1.00);
	}

	public int getProdutoID() {
		return this.produtoID;
	}

	public void setProdutoID(int produtoID) {
		this.produtoID = produtoID;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public short getSku() {
		return this.sku;
	}

	public void setSku(short sku) {
		this.sku = sku;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<ProdutoEntrega> getProdutoEntregas() {
		return this.produtoEntregas;
	}

	public void setProdutoEntregas(List<ProdutoEntrega> produtoEntregas) {
		this.produtoEntregas = produtoEntregas;
	}

	public ProdutoEntrega addProdutoEntrega(ProdutoEntrega produtoEntrega) {
		getProdutoEntregas().add(produtoEntrega);
		produtoEntrega.setProduto(this);

		return produtoEntrega;
	}

	public ProdutoEntrega removeProdutoEntrega(ProdutoEntrega produtoEntrega) {
		getProdutoEntregas().remove(produtoEntrega);
		produtoEntrega.setProduto(null);

		return produtoEntrega;
	}

}