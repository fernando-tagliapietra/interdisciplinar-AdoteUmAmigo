package dto;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@Table(name="animal")
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="disponivel_adocao", nullable=false)
	private int disponivelAdocao;

	@Column(nullable=false, length=1)
	private String genero;

	@Column(nullable=false)
	private int idade;

	@Column(name="nome_adotivo", nullable=false, length=80)
	private String nomeAdotivo;

	@Column(nullable=false, length=40)
	private String tipo;

	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="adocao_id")
	private Adocao adocao;*/
	
	
	@Column(name="adocao_id", nullable=true)
	private int adocaoId;
	
	
	
	
	public int getAdocaoId() {
		return adocaoId;
	}

	public void setAdocaoId(int adocaoId) {
		this.adocaoId = adocaoId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Animal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisponivelAdocao() {
		return this.disponivelAdocao;
	}

	public void setDisponivelAdocao(int disponivelAdocao) {
		this.disponivelAdocao = disponivelAdocao;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNomeAdotivo() {
		return this.nomeAdotivo;
	}

	public void setNomeAdotivo(String nomeAdotivo) {
		this.nomeAdotivo = nomeAdotivo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}