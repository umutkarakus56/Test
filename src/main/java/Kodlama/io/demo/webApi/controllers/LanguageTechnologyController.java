package Kodlama.io.demo.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.demo.business.abstracts.LanguageTechnologyService;
import Kodlama.io.demo.business.requests.languageTechnologies.CreateLanguageTechnologiesRequest;
import Kodlama.io.demo.business.requests.languageTechnologies.UpdateLanguageTechnologiesRequest;
import Kodlama.io.demo.business.responses.languageTechnologies.GetAllLanguageTechnologiesResponses;
import Kodlama.io.demo.business.responses.languageTechnologies.GetByIdLanguageTechnologiesResponses;

@RestController
@RequestMapping("/api/technology")
public class LanguageTechnologyController {	
	
	private LanguageTechnologyService languageTechnologyService;

	public LanguageTechnologyController(LanguageTechnologyService languageTechnologyService) {
		this.languageTechnologyService = languageTechnologyService;
	}

@GetMapping("/get/all")
	public List<GetAllLanguageTechnologiesResponses> getAll(){
	
		return languageTechnologyService.getAll();
}
		
@PostMapping("/add")
	public void add(@RequestBody() CreateLanguageTechnologiesRequest createLanguageTechnologiesRequest ) 
		throws Exception {

	this.languageTechnologyService.add(createLanguageTechnologiesRequest);
	
}
@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") int id ) {
	
	languageTechnologyService.delete(id);
}

@PutMapping("/update")
	public void update(@RequestBody()UpdateLanguageTechnologiesRequest updateLanguageTechnologiesRequest ) {
	this.languageTechnologyService.update(updateLanguageTechnologiesRequest);
}

@GetMapping("/get/{id}")
	public GetByIdLanguageTechnologiesResponses getById(@PathVariable(name="id") int id) {
	return languageTechnologyService.getById(id);
}

}
