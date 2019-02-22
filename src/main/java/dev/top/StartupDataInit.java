package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.ColleguesRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

	@Autowired
	VersionRepo versionRepo;

	@Autowired
	ColleguesRepo colleguesRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		this.versionRepo.save(new Version("v1"));
		this.versionRepo.save(new Version("v2"));
		this.versionRepo.save(new Version("v3"));
		this.versionRepo.save(new Version("v4"));

		this.colleguesRepo
				.save(new Collegue("Aria", 0, "https://myanimelist.cdn-dena.com/images/characters/7/113250.jpg"));

		this.colleguesRepo
				.save(new Collegue("Tanya", 0, "https://myanimelist.cdn-dena.com/images/characters/11/319996.jpg"));
		this.colleguesRepo
				.save(new Collegue("Minami", 0, "https://myanimelist.cdn-dena.com/images/characters/9/82468.jpg"));
		this.colleguesRepo
				.save(new Collegue("Yuuki", 0, "https://myanimelist.cdn-dena.com/images/characters/4/278171.jpg"));
		this.colleguesRepo.save(
				new Collegue("Tatsumaki", 0, "https://myanimelist.cdn-dena.com/images/characters/16/296299.jpg"));
		this.colleguesRepo
				.save(new Collegue("Jeanne", 0, "https://myanimelist.cdn-dena.com/images/characters/2/148927.jpg"));
		this.colleguesRepo
				.save(new Collegue("Reki", 0, "https://myanimelist.cdn-dena.com/images/characters/6/148931.jpg"));
		this.colleguesRepo
				.save(new Collegue("Rukia", 0, "https://myanimelist.cdn-dena.com/images/characters/2/78215.jpg"));
		this.colleguesRepo
				.save(new Collegue("Sarada", 0, "https://myanimelist.cdn-dena.com/images/characters/5/292448.jpg"));

	}
}
