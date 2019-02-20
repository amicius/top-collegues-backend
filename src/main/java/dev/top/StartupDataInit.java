package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegues;
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
				.save(new Collegues("Aria", 10, "https://myanimelist.cdn-dena.com/images/characters/7/113250.jpg"));

		this.colleguesRepo
				.save(new Collegues("Tanya", 20, "https://myanimelist.cdn-dena.com/images/characters/11/319996.jpg"));

	}
}
