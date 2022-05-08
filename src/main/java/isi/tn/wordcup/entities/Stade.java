package isi.tn.wordcup.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "stades", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "nom")
	})
public class Stade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nom;
	@NotBlank
	@Size(max = 50)
	private String localisation;
	private String image;
	@OneToMany(mappedBy="stade")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Match> matchs;
	
	public Stade() {
	}

	public Stade(Long id, @NotBlank @Size(max = 50) String nom, @NotBlank @Size(max = 50) String localisation,
			String image, Collection<Match> matchs) {
		super();
		this.id = id;
		this.nom = nom;
		this.localisation = localisation;
		this.image = image;
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

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Collection<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(Collection<Match> matchs) {
		this.matchs = matchs;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
