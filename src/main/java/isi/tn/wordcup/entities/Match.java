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
	@ManyToOne
	private Equipe nomEquipe1;
	@NotBlank
	@Size(max = 50)
	@ManyToOne
	private Equipe nomEquipe2;
	@Size(max=10)
	private String resultat;
	private Date date;
	@ManyToOne
	private Tournoi tournoi;
	@ManyToOne
	private Stade stade;
	@OneToMany(mappedBy="match")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Arbitre> arbitres;
		
	public Match() {
	}

	public Match(Long id, @NotBlank @Size(max = 50) Equipe nomEquipe1, @NotBlank @Size(max = 50) Equipe nomEquipe2,
			@Size(max = 10) String resultat, Date date, Tournoi tournoi, Stade stade, Collection<Arbitre> arbitres) {
		super();
		this.id = id;
		this.nomEquipe1 = nomEquipe1;
		this.nomEquipe2 = nomEquipe2;
		this.resultat = resultat;
		this.date = date;
		this.tournoi = tournoi;
		this.stade = stade;
		this.arbitres = arbitres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipe getNomEquipe1() {
		return nomEquipe1;
	}

	public void setNomEquipe1(Equipe nomEquipe1) {
		this.nomEquipe1 = nomEquipe1;
	}

	public Equipe getNomEquipe2() {
		return nomEquipe2;
	}

	public void setNomEquipe2(Equipe nomEquipe2) {
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

	public Tournoi getTournoir() {
		return tournoi;
	}

	public void setTournoir(Tournoi tournoi) {
		this.tournoi = tournoi;
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
