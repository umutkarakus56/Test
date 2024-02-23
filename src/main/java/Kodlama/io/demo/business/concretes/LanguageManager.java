package Kodlama.io.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.demo.business.abstracts.LanguageService;
import Kodlama.io.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.demo.business.requests.languages.DeleteLanguagesRequest;
import Kodlama.io.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.demo.business.responses.languages.GetAllLanguagesReponses;
import Kodlama.io.demo.business.responses.languages.GetByIdLanguagesResponses;
import Kodlama.io.demo.core.mappers.ModelMapperService;
import Kodlama.io.demo.dataAcces.abstracts.LanguageRepository;
import Kodlama.io.demo.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageRepository languageRepository ;
	private ModelMapperService modelMapperService;
	
@Override
public List<GetAllLanguagesReponses> getAll(){
	List<Language> languages = languageRepository.findAll();
	List<GetAllLanguagesReponses> languagesReponses = new ArrayList<GetAllLanguagesReponses>();
	
for(Language language : languages ) {
	GetAllLanguagesReponses responseItem = new GetAllLanguagesReponses();
	responseItem.setId(language.getId());
	responseItem.setName(language.getName());
	
	languagesReponses.add(responseItem);
	
}
return languagesReponses;

}
	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}


	@Override
	public void add(CreateLanguagesRequest createLanguagesRequest) {
	
	Language language = new Language();
	language.setId(createLanguagesRequest.getId());
	language.setName(createLanguagesRequest.getName());
if(createLanguagesRequest.getName() == "") 
	{
		System.out.println("You cannot be left blank.");
	}
else if(this.languageRepository.getByName(createLanguagesRequest.getName() == null))
	{
		System.out.println("You got this lesson so you cannot take it.");
	}
			
	}

@Override
	public void delete(DeleteLanguagesRequest deleteLanguagesRequest,int id) {
		
		languageRepository.deleteById(deleteLanguagesRequest.getId());
		
	}

	@Override
	public void update(UpdateLanguagesRequest updateLanguagesRequest){
		Language language = this.modelMapperService.forRequest().map(updateLanguagesRequest,Language.class);
		this.languageRepository.save(language);	
		
	}
	@Override
	public GetByIdLanguagesResponses getById(int id) {
		Language language = this.languageRepository.findById(id).orElse(null);
		GetByIdLanguagesResponses response = this.modelMapperService.forResponse().map(language, GetByIdLanguagesResponses.class);
		return response;
	}


}
