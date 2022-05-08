package isi.tn.wordcup.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tournois")
public class Tournoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	@OneToMany(mappedBy="tournoi")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Match> matchs;
	
	public Tournoi() {
	}

	public Tournoi(Long id, @NotBlank @Size(max = 50) String nom, Date dateDebut, Date dateFin,
			Collection<Match> matchs) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.matchs = matchs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Collection<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(Collection<Match> matchs) {
		this.matchs = matchs;
	}

}
