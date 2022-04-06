package isi.tn.wordcup.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "matchs")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nomEquipe1;
	@NotBlank
	@Size(max = 50)
	private String nomEquipe2;
	@Size(max=10)
	private String resultat;
	private Date date;
	@ManyToOne
	private Equipe equipe;
	@ManyToOne
	private Tournoir tournoir;
	@ManyToOne
	private Stade stade;
	@OneToMany(mappedBy="match")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Arbitre> arbitres;
		
	public Match() {
	}

	public Match(Long id, @NotBlank @Size(max = 50) String nomEquipe1, @NotBlank @Size(max = 50) String nomEquipe2,
			@Size(max = 10) String resultat, Date date, Equipe equipe, Tournoir tournoir, Stade stade,
			Collection<Arbitre> arbitres) {
		super();
		this.id = id;
		this.nomEquipe1 = nomEquipe1;
		this.nomEquipe2 = nomEquipe2;
		this.resultat = resultat;
		this.date = date;
		this.equipe = equipe;
		this.tournoir = tournoir;
		this.stade = stade;
		this.arbitres = arbitres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEquipe1() {
		return nomEquipe1;
	}

	public void setNomEquipe1(String nomEquipe1) {
		this.nomEquipe1 = nomEquipe1;
	}

	public String getNomEquipe2() {
		return nomEquipe2;
	}

	public void setNomEquipe2(String nomEquipe2) {
		this.nomEquipe2 = nomEquipe2;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Tournoir getTournoir() {
		return tournoir;
	}

	public void setTournoir(Tournoir tournoir) {
		this.tournoir = tournoir;
	}

	public Stade getStade() {
		return stade;
	}

	public void setStade(Stade stade) {
		this.stade = stade;
	}

	public Collection<Arbitre> getArbitres() {
		return arbitres;
	}

	public void setArbitres(Collection<Arbitre> arbitres) {
		this.arbitres = arbitres;
	}

	
}
