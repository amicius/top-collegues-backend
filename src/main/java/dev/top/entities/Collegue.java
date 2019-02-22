package dev.top.entities;

import javax.persistence.Entity;

@Entity
public class Collegue extends CollegueLight {

	private String matricule;

	private String nom;

	private String prenom;

	private String email;

	private String adresse;

	public Collegue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collegue(String pseudo, Integer score, String photoUrl) {
		super(pseudo, score, photoUrl);
		// TODO Auto-generated constructor stub
	}

	public Collegue(String pseudo, String photoUrl, String matricule, String nom, String prenom, String email,
			String adresse) {
		super(pseudo, 0, photoUrl);
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public CollegueLight toCollegueLight() {
		return new CollegueLight(this.getPseudo(), this.getScore(), this.getPhotoUrl());
	}

}
