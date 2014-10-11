/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.somotoresentregas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(catalog = "somotore_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByEntregaID", query = "SELECT e FROM Entrega e WHERE e.entregaID = :entregaID"),
    @NamedQuery(name = "Entrega.findByDestinatario", query = "SELECT e FROM Entrega e WHERE e.destinatario = :destinatario"),
    @NamedQuery(name = "Entrega.findByEmpresa", query = "SELECT e FROM Entrega e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "Entrega.findByTelefone", query = "SELECT e FROM Entrega e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Entrega.findByEndereco", query = "SELECT e FROM Entrega e WHERE e.endereco = :endereco"),
    @NamedQuery(name = "Entrega.findByTipoEndereco", query = "SELECT e FROM Entrega e WHERE e.tipoEndereco = :tipoEndereco"),
    @NamedQuery(name = "Entrega.findByNumero", query = "SELECT e FROM Entrega e WHERE e.numero = :numero"),
    @NamedQuery(name = "Entrega.findByComplemento", query = "SELECT e FROM Entrega e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Entrega.findByCidade", query = "SELECT e FROM Entrega e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Entrega.findByEstado", query = "SELECT e FROM Entrega e WHERE e.estado = :estado"),
    @NamedQuery(name = "Entrega.findByCep", query = "SELECT e FROM Entrega e WHERE e.cep = :cep"),
    @NamedQuery(name = "Entrega.findByObservacaoFinal", query = "SELECT e FROM Entrega e WHERE e.observacaoFinal = :observacaoFinal"),
    @NamedQuery(name = "Entrega.findByObservacaoCadastro", query = "SELECT e FROM Entrega e WHERE e.observacaoCadastro = :observacaoCadastro"),
    @NamedQuery(name = "Entrega.findByTempoEstimado", query = "SELECT e FROM Entrega e WHERE e.tempoEstimado = :tempoEstimado"),
    @NamedQuery(name = "Entrega.findByPrioridade", query = "SELECT e FROM Entrega e WHERE e.prioridade = :prioridade"),
    @NamedQuery(name = "Entrega.findByCustoFrete", query = "SELECT e FROM Entrega e WHERE e.custoFrete = :custoFrete"),
    @NamedQuery(name = "Entrega.findByCheckin", query = "SELECT e FROM Entrega e WHERE e.checkin = :checkin"),
    @NamedQuery(name = "Entrega.findByCheckout", query = "SELECT e FROM Entrega e WHERE e.checkout = :checkout"),
    @NamedQuery(name = "Entrega.findByStatusDesc", query = "SELECT e FROM Entrega e WHERE e.statusDesc = :statusDesc"),
    @NamedQuery(name = "Entrega.findByStatusCod", query = "SELECT e FROM Entrega e WHERE e.statusCod = :statusCod"),
    @NamedQuery(name = "Entrega.findByIsAlerta", query = "SELECT e FROM Entrega e WHERE e.isAlerta = :isAlerta"),
    @NamedQuery(name = "Entrega.findByAbertoDate", query = "SELECT e FROM Entrega e WHERE e.abertoDate = :abertoDate"),
    @NamedQuery(name = "Entrega.findByFechadoDate", query = "SELECT e FROM Entrega e WHERE e.fechadoDate = :fechadoDate")})
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer entregaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String destinatario;
    @Size(max = 30)
    @Column(length = 30)
    private String empresa;
    @Size(max = 20)
    @Column(length = 20)
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String endereco;
    private Character tipoEndereco;
    private Integer numero;
    @Size(max = 40)
    @Column(length = 40)
    private String complemento;
    @Size(max = 30)
    @Column(length = 30)
    private String cidade;
    @Size(max = 2)
    @Column(length = 2)
    private String estado;
    @Size(max = 8)
    @Column(length = 8)
    private String cep;
    @Size(max = 200)
    @Column(name = "observacao_final", length = 200)
    private String observacaoFinal;
    @Size(max = 200)
    @Column(name = "observacao_cadastro", length = 200)
    private String observacaoCadastro;
    private Integer tempoEstimado;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short prioridade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal custoFrete;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkout;
    @Size(max = 15)
    @Column(name = "status_desc", length = 15)
    private String statusDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_cod", nullable = false)
    private short statusCod;
    private Integer isAlerta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date abertoDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadoDate;
    @JoinColumn(name = "usuarioID", referencedColumnName = "usuarioID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entregaID")
    private List<ProdutoEntrega> produtoEntregaList;

    public Entrega() {
    }

    public Entrega(Integer entregaID) {
        this.entregaID = entregaID;
    }

    public Entrega(Integer entregaID, String destinatario, String endereco, short prioridade, BigDecimal custoFrete, short statusCod) {
        this.entregaID = entregaID;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.prioridade = prioridade;
        this.custoFrete = custoFrete;
        this.statusCod = statusCod;
    }

    public Integer getEntregaID() {
        return entregaID;
    }

    public void setEntregaID(Integer entregaID) {
        this.entregaID = entregaID;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Character getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(Character tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getObservacaoFinal() {
        return observacaoFinal;
    }

    public void setObservacaoFinal(String observacaoFinal) {
        this.observacaoFinal = observacaoFinal;
    }

    public String getObservacaoCadastro() {
        return observacaoCadastro;
    }

    public void setObservacaoCadastro(String observacaoCadastro) {
        this.observacaoCadastro = observacaoCadastro;
    }

    public Integer getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Integer tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public short getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(short prioridade) {
        this.prioridade = prioridade;
    }

    public BigDecimal getCustoFrete() {
        return custoFrete;
    }

    public void setCustoFrete(BigDecimal custoFrete) {
        this.custoFrete = custoFrete;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public short getStatusCod() {
        return statusCod;
    }

    public void setStatusCod(short statusCod) {
        this.statusCod = statusCod;
    }

    public Integer getIsAlerta() {
        return isAlerta;
    }

    public void setIsAlerta(Integer isAlerta) {
        this.isAlerta = isAlerta;
    }

    public Date getAbertoDate() {
        return abertoDate;
    }

    public void setAbertoDate(Date abertoDate) {
        this.abertoDate = abertoDate;
    }

    public Date getFechadoDate() {
        return fechadoDate;
    }

    public void setFechadoDate(Date fechadoDate) {
        this.fechadoDate = fechadoDate;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    @XmlTransient
    public List<ProdutoEntrega> getProdutoEntregaList() {
        return produtoEntregaList;
    }

    public void setProdutoEntregaList(List<ProdutoEntrega> produtoEntregaList) {
        this.produtoEntregaList = produtoEntregaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entregaID != null ? entregaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.entregaID == null && other.entregaID != null) || (this.entregaID != null && !this.entregaID.equals(other.entregaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.somotoresentregas.model.Entrega[ entregaID=" + entregaID + " ]";
    }
    
}
