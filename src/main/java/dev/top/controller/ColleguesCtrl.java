package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> updateResource(@RequestBody String action, @PathVariable("pseudo") String pseudo) {
		if (action.equals("AIMER")) {
			this.colleguesRepo.findById(pseudo).get()
					.setScore(this.colleguesRepo.findById(pseudo).get().getScore() + 10);
			this.colleguesRepo.flush();
			return ResponseEntity.ok("resource updated");
		} else if (action.equals("DETESTER")) {
			this.colleguesRepo.findById(pseudo).get()
					.setScore(this.colleguesRepo.findById(pseudo).get().getScore() - 5);
			this.colleguesRepo.flush();
			return ResponseEntity.ok("resource updated");

		}
		return ResponseEntity.ok("mauvaise action");

	}

}
