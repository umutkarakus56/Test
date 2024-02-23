package Kodlama.io.demo.business.abstracts;

import java.util.List;

import Kodlama.io.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.demo.business.requests.languages.DeleteLanguagesRequest;
import Kodlama.io.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.demo.business.responses.languages.GetAllLanguagesReponses;
import Kodlama.io.demo.business.responses.languages.GetByIdLanguagesResponses;

public interface LanguageService {
	List<GetAllLanguagesReponses> getAll();
	
	void add(CreateLanguagesRequest createLanguagesRequest);
	void update(UpdateLanguagesRequest updateLanguagesRequest);
	GetByIdLanguagesResponses getById(int id);
	void delete(DeleteLanguagesRequest deleteLanguagesRequest,int id);


	
}
