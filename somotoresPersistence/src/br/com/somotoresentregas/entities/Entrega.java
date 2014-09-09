package br.com.somotoresentregas.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the entrega database table.
 * 
 */
@Entity
@NamedQuery(name="Entrega.findAll", query="SELECT e FROM Entrega e")
public class Entrega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int entregaID;

	private Timestamp abertoDate;

	private String cep;

	private Timestamp checkin;

	private Timestamp checkout;

	private String cidade;

	private String complemento;

	private BigDecimal custoFrete;

	private String destinatario;

	private String empresa;

	private String endereco;

	private String estado;

	private Timestamp fechadoDate;

	private byte isAlerta;

	private int numero;

	@Column(name="observacao_cadastro")
	private String observacaoCadastro;

	@Column(name="observacao_final")
	private String observacaoFinal;

	private short prioridade;

	@Column(name="status_cod")
	private short statusCod;

	@Column(name="status_desc")
	private String statusDesc;

	private String telefone;

	private int tempoEstimado;

	private String tipoEndereco;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarioID")
	private Usuario usuario;

	//bi-directional many-to-one association to ProdutoEntrega
	@OneToMany(mappedBy="entrega")
	private List<ProdutoEntrega> produtoEntregas;

	public Entrega() {
	}

	public int getEntregaID() {
		return this.entregaID;
	}

	public void setEntregaID(int entregaID) {
		this.entregaID = entregaID;
	}

	public Timestamp getAbertoDate() {
		return this.abertoDate;
	}

	public void setAbertoDate(Timestamp abertoDate) {
		this.abertoDate = abertoDate;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Timestamp getCheckin() {
		return this.checkin;
	}

	public void setCheckin(Timestamp checkin) {
		this.checkin = checkin;
	}

	public Timestamp getCheckout() {
		return this.checkout;
	}

	public void setCheckout(Timestamp checkout) {
		this.checkout = checkout;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public BigDecimal getCustoFrete() {
		return this.custoFrete;
	}

	public void setCustoFrete(BigDecimal custoFrete) {
		this.custoFrete = custoFrete;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechadoDate() {
		return this.fechadoDate;
	}

	public void setFechadoDate(Timestamp fechadoDate) {
		this.fechadoDate = fechadoDate;
	}

	public byte getIsAlerta() {
		return this.isAlerta;
	}

	public void setIsAlerta(byte isAlerta) {
		this.isAlerta = isAlerta;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getObservacaoCadastro() {
		return this.observacaoCadastro;
	}

	public void setObservacaoCadastro(String observacaoCadastro) {
		this.observacaoCadastro = observacaoCadastro;
	}

	public String getObservacaoFinal() {
		return this.observacaoFinal;
	}

	public void setObservacaoFinal(String observacaoFinal) {
		this.observacaoFinal = observacaoFinal;
	}

	public short getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(short prioridade) {
		this.prioridade = prioridade;
	}

	public short getStatusCod() {
		return this.statusCod;
	}

	public void setStatusCod(short statusCod) {
		this.statusCod = statusCod;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTempoEstimado() {
		return this.tempoEstimado;
	}

	public void setTempoEstimado(int tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public String getTipoEndereco() {
		return this.tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProdutoEntrega> getProdutoEntregas() {
		return this.produtoEntregas;
	}

	public void setProdutoEntregas(List<ProdutoEntrega> produtoEntregas) {
		this.produtoEntregas = produtoEntregas;
	}

	public ProdutoEntrega addProdutoEntrega(ProdutoEntrega produtoEntrega) {
		getProdutoEntregas().add(produtoEntrega);
		produtoEntrega.setEntrega(this);

		return produtoEntrega;
	}

	public ProdutoEntrega removeProdutoEntrega(ProdutoEntrega produtoEntrega) {
		getProdutoEntregas().remove(produtoEntrega);
		produtoEntrega.setEntrega(null);

		return produtoEntrega;
	}

}