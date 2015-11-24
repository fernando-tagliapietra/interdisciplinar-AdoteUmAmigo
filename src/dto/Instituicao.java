package dto;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the instituicao database table.
 * 
 */
@Entity
@Table(name="instituicao")
@NamedQuery(name="Instituicao.findAll", query="SELECT i FROM Instituicao i")
public class Instituicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String cnpj;

	@Column(nullable=false, length=60)
	private String email;

	@Column(nullable=false, length=60)
	private String endereco;

	@Column(nullable=false, length=80)
	private String nome;

	@Column(nullable=false, length=20)
	private String telefone;

	@Column(nullable=false, length=40)
	private String tipo;

	public Instituicao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}