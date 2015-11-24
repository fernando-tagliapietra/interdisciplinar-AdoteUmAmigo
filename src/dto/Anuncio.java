package dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the anuncio database table.
 * 
 */
@Entity
@Table(name="anuncio")
@NamedQuery(name="Anuncio.findAll", query="SELECT a FROM Anuncio a")
public class Anuncio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="animal_id", nullable=false)
	private int animalId;

	@Column(nullable=false, length=200)
	private String descricao;

	public Anuncio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnimalId() {
		return this.animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}