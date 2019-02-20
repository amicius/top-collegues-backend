package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collegues {

	@Id
	private String pseudo;

	private Integer score;

	private String imageUrl;

	public Collegues() {
		super();
	}

	public Collegues(String pseudo, Integer score, String imageUrl) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.imageUrl = imageUrl;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
