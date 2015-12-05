package dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * The persistent class for the adocao database table.
 * 
 */
@Entity
@Table(name="adocao")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Adocao.findAll", query="SELECT a FROM Adocao a")
public class Adocao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;

	@Column(name="pessoa_id", nullable=false)
	private int pessoaId;

	@Column(name="instituicao_id", nullable=false)
	private int instituicaoId;
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="instituicao_id")
	private Instituicao instituicao;*/
	
	@Transient
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	
	
	public void addAnimal(Animal animal){
		animais.add(animal);
	}
	
	public ArrayList<Animal> getAnimals(){
		return this.animais;
	}
	
	
	public Adocao() {
	}

	public int getId() {
		return this.id;
	}

	public int getInstituicaoId() {
		return instituicaoId;
	}

	public void setInstituicaoId(int instituicaoId) {
		this.instituicaoId = instituicaoId;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPessoaId() {
		return this.pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

}