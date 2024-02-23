package Kodlama.io.demo.business.abstracts;

import java.util.List;

import Kodlama.io.demo.business.requests.languageTechnologies.CreateLanguageTechnologiesRequest;
import Kodlama.io.demo.business.requests.languageTechnologies.UpdateLanguageTechnologiesRequest;
import Kodlama.io.demo.business.responses.languageTechnologies.GetAllLanguageTechnologiesResponses;
import Kodlama.io.demo.business.responses.languageTechnologies.GetByIdLanguageTechnologiesResponses;

public interface LanguageTechnologyService {
	List<GetAllLanguageTechnologiesResponses> getAll();
	
	void add(CreateLanguageTechnologiesRequest createLanguageTechnologiesRequest);
	void update(UpdateLanguageTechnologiesRequest updateLanguageTechnologiesRequest);
	void delete(int id);
	GetByIdLanguageTechnologiesResponses getById(int id);

	
	

}
