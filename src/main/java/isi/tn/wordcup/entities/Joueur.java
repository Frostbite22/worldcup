package isi.tn.wordcup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "joueurs", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "nom"),
		@UniqueConstraint(columnNames = "prenom") 
	})
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nom;
	@NotBlank
	@Size(max = 50)
	private String prenom;
	private int age;
	private double taille;
	private String poids;
	private String poste;
	private int numMaillot;
	@ManyToOne
	private Equipe equipe;
	
	public Joueur() {
	}

	public Joueur(Long id, @NotBlank @Size(max = 50) String nom, @NotBlank @Size(max = 50) String prenom, int age,
			double taille, String poids, String poste, int numMaillot, Equipe equipe) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.poste = poste;
		this.numMaillot = numMaillot;
		this.equipe = equipe;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public int getNumMaillot() {
		return numMaillot;
	}

	public void setNumMaillot(int numMaillot) {
		this.numMaillot = numMaillot;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	
}
