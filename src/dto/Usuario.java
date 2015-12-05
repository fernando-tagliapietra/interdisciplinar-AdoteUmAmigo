package dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=60)
	private String email;

	@Column(name="perfil_acesso", nullable=false, length=60)
	private String perfilAcesso;

	@Column(nullable=false, length=60)
	private String senha;

	@Transient
	private Pessoa pessoa;
	
	public Usuario() {
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario(String email, String acesso, String senha){
		this.email 	= email;
		this.perfilAcesso = acesso;
		this.senha = senha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfilAcesso() {
		return this.perfilAcesso;
	}

	public void setPerfilAcesso(String perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}