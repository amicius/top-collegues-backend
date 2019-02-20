package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
