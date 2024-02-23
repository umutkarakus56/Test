package Kodlama.io.demo.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.demo.business.abstracts.LanguageService;
import Kodlama.io.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.demo.business.responses.languages.GetAllLanguagesReponses;
import Kodlama.io.demo.business.responses.languages.GetByIdLanguagesResponses;

@RestController
@RequestMapping("/api/languages")



public class LanguageController {
	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

@GetMapping("/get/all")
	public List<GetAllLanguagesReponses> getAll(){
	
	return languageService.getAll();
}

@PostMapping("/add")
	public void add(@RequestBody() CreateLanguagesRequest createLanguagesRequest) throws Exception{
	
	this.languageService.add(createLanguagesRequest);
}

@DeleteMapping("/delete")
	public void delete(@RequestBody()  int id) {
	
	this.languageService.delete(null,id);
}

@PutMapping("/update")
	public void update(@RequestBody()  UpdateLanguagesRequest updateLanguagesRequest) {
	
	this.languageService.update(updateLanguagesRequest);
}

@GetMapping("/get/{id}")
	public GetByIdLanguagesResponses getById(int id) {
	
	return languageService.getById(id);
}
	
	
}
