package dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name="pessoa")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=60)
	private String conjuge;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento", nullable=false)
	private Date dataNascimento;

	@Column(nullable=false)
	private int deficiencia;

	@Column(nullable=false, length=60)
	private String etnia;

	@Column(nullable=false, length=2)
	private String genero;

	@Column(name="nome_mae1", nullable=false, length=60)
	private String nomeMae1;

	@Column(name="nome_mae2", nullable=false, length=60)
	private String nomeMae2;

	@Column(name="nome_pai1", nullable=false, length=60)
	private String nomePai1;

	@Column(name="nome_pai2", nullable=false, length=60)
	private String nomePai2;

	@Column(name="nome_social", nullable=false, length=60)
	private String nomeSocial;

	@Column(nullable=false, length=60)
	private String religiao;

	@Column(nullable=false, length=20)
	private String telefone;

	@Column(name="usuario_id", nullable=false)
	private int usuarioId;

	public Pessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConjuge() {
		return this.conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getDeficiencia() {
		return this.deficiencia;
	}

	public void setDeficiencia(int deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNomeMae1() {
		return this.nomeMae1;
	}

	public void setNomeMae1(String nomeMae1) {
		this.nomeMae1 = nomeMae1;
	}

	public String getNomeMae2() {
		return this.nomeMae2;
	}

	public void setNomeMae2(String nomeMae2) {
		this.nomeMae2 = nomeMae2;
	}

	public String getNomePai1() {
		return this.nomePai1;
	}

	public void setNomePai1(String nomePai1) {
		this.nomePai1 = nomePai1;
	}

	public String getNomePai2() {
		return this.nomePai2;
	}

	public void setNomePai2(String nomePai2) {
		this.nomePai2 = nomePai2;
	}

	public String getNomeSocial() {
		return this.nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getReligiao() {
		return this.religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

}