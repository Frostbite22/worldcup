package isi.tn.wordcup.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "equipes",uniqueConstraints = { 
		@UniqueConstraint(columnNames = "nom")
	})
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nom;
	@ManyToOne
	private Groupe groupe;
	@OneToMany(mappedBy="equipe")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Jouer> jouers;
	@OneToMany(mappedBy="equipe")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Tournoir> tournoirs;
	@OneToMany(mappedBy="equipe")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Match> matchs;
	
	
	public Equipe() {
	}


	public Equipe(Long id, @NotBlank @Size(max = 50) String nom, Groupe groupe, Collection<Jouer> jouers,
			Collection<Tournoir> tournoirs, Collection<Match> matchs) {
		super();
		this.id = id;
		this.nom = nom;
		this.groupe = groupe;
		this.jouers = jouers;
		this.tournoirs = tournoirs;
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


	public Groupe getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}


	public Collection<Jouer> getJouers() {
		return jouers;
	}


	public void setJouers(Collection<Jouer> jouers) {
		this.jouers = jouers;
	}


	public Collection<Tournoir> getTournoirs() {
		return tournoirs;
	}


	public void setTournoirs(Collection<Tournoir> tournoirs) {
		this.tournoirs = tournoirs;
	}


	public Collection<Match> getMatchs() {
		return matchs;
	}


	public void setMatchs(Collection<Match> matchs) {
		this.matchs = matchs;
	}

	
	
}
