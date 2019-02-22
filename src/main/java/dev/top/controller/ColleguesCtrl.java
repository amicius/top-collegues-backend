package dev.top.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.entities.CollegueLight;
import dev.top.repos.ColleguesRepo;

@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class ColleguesCtrl {

	@Autowired
	private ColleguesRepo colleguesRepo;

	@GetMapping
	public List<CollegueLight> findAll() {
		return this.colleguesRepo.findAll().stream().map(Collegue::toCollegueLight).collect(Collectors.toList());
	}

	@PatchMapping("/{pseudo}")
	public CollegueLight updateResource(@RequestBody UtilsCtrl action, @PathVariable("pseudo") String pseudo) {
		Optional<Collegue> collegueRecherche = this.colleguesRepo.findById(pseudo);

		if (collegueRecherche.isPresent()) {
			Collegue temp = collegueRecherche.get();
			if (action.getAction() == Avis.AIMER) {
				temp.setScore(temp.getScore() + 10);
			} else if (action.getAction() == Avis.DETESTER) {
				temp.setScore(temp.getScore() - 5);
			}
			return colleguesRepo.save(temp).toCollegueLight();
		}
		return null;

	}

	@PostMapping
	public void addUser(@RequestBody CollegueLight collegue) {

	}

}
