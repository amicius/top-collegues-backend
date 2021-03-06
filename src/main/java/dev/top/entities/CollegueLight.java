package dev.top.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CollegueLight {

	@Id
	private String pseudo;

	private Integer score;

	private String photoUrl;

	public CollegueLight() {
		super();
	}

	public CollegueLight(String pseudo, Integer score, String photoUrl) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.photoUrl = photoUrl;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
