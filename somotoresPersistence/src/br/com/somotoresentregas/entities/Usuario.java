package br.com.somotoresentregas.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.findByLogin", query="SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usuarioID;

	@Temporal(TemporalType.DATE)
	private Date autorizacaoDate;

	private int autorizadorID;

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String cpf;

	private String email;

	private String endereco;

	private String estado;

	private int isAtivo;

	private int isLogado;

	private float latitude;

	private String login;

	private float longitude;

	private String matricula;

	@Temporal(TemporalType.DATE)
	private Date nascimentoDate;

	private String nome;

	private int numero;

	private String perfil;

	private String rg;

	private String senha;

	private String sexo;

	private String sobrenome;

	private String telefone;

	private String veiculo;

	//bi-directional many-to-one association to Entrega
	@OneToMany(mappedBy="usuario")
	private List<Entrega> entregas;

	public Usuario() {
	}

	public int getUsuarioID() {
		return this.usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public Date getAutorizacaoDate() {
		return this.autorizacaoDate;
	}

	public void setAutorizacaoDate(Date autorizacaoDate) {
		this.autorizacaoDate = autorizacaoDate;
	}

	public int getAutorizadorID() {
		return this.autorizadorID;
	}

	public void setAutorizadorID(int autorizadorID) {
		this.autorizadorID = autorizadorID;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getIsAtivo() {
		return this.isAtivo;
	}

	public void setIsAtivo(int isAtivo) {
		this.isAtivo = isAtivo;
	}

	public int getIsLogado() {
		return this.isLogado;
	}

	public void setIsLogado(int isLogado) {
		this.isLogado = isLogado;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getNascimentoDate() {
		return this.nascimentoDate;
	}

	public void setNascimentoDate(Date nascimentoDate) {
		this.nascimentoDate = nascimentoDate;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public List<Entrega> getEntregas() {
		return this.entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Entrega addEntrega(Entrega entrega) {
		getEntregas().add(entrega);
		entrega.setUsuario(this);

		return entrega;
	}

	public Entrega removeEntrega(Entrega entrega) {
		getEntregas().remove(entrega);
		entrega.setUsuario(null);

		return entrega;
	}

}