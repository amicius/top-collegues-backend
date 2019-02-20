package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegues;
import dev.top.repos.ColleguesRepo;

@RestController()
@RequestMapping("/collegues")
public class ColleguesCtrl {

	@Autowired
	private ColleguesRepo colleguesRepo;

	@GetMapping
	public List<Collegues> findAll() {
		return this.colleguesRepo.findAll();
	}

	@PatchMapping("/{pseudo}")
	public Collegues updateResource(@RequestBody UtilsCtrl action, @PathVariable("pseudo") String pseudo) {
		if (this.colleguesRepo.findById(pseudo).isPresent()) {
			Collegues temp = this.colleguesRepo.findById(pseudo).get();
			if (action.getAction() == Avis.AIMER) {
				temp.setScore(temp.getScore() + 10);
				return colleguesRepo.save(temp);
			} else if (action.getAction() == Avis.DETESTER) {
				temp.setScore(temp.getScore() - 5);
				return colleguesRepo.save(temp);
			}
		}
		return null;

	}

}
