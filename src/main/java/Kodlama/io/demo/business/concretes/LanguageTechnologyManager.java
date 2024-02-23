package Kodlama.io.demo.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.demo.business.abstracts.LanguageTechnologyService;
import Kodlama.io.demo.business.requests.languageTechnologies.CreateLanguageTechnologiesRequest;
import Kodlama.io.demo.business.requests.languageTechnologies.UpdateLanguageTechnologiesRequest;
import Kodlama.io.demo.business.responses.languageTechnologies.GetAllLanguageTechnologiesResponses;
import Kodlama.io.demo.business.responses.languageTechnologies.GetByIdLanguageTechnologiesResponses;
import Kodlama.io.demo.core.mappers.ModelMapperService;
import Kodlama.io.demo.dataAcces.abstracts.LanguageTechnologyRepository;
import Kodlama.io.demo.entities.concretes.LanguageTechnology;
@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {

	private LanguageTechnologyRepository technologyRepository;
	private ModelMapperService modelMapperService;
	
public List<GetAllLanguageTechnologiesResponses> getAll() {
		List<LanguageTechnology> languageTechnologies = technologyRepository.findAll();
		List<GetAllLanguageTechnologiesResponses> technologiesResponses = languageTechnologies.stream()
		.map( languageTechnology ->modelMapperService.forResponse()
		.map(languageTechnology, GetAllLanguageTechnologiesResponses.class)).collect(Collectors.toList());
	return technologiesResponses;
}

	
	@Override
	public void add(CreateLanguageTechnologiesRequest createLanguageTechnologiesRequest) {
	
	LanguageTechnology languageTechnology = new LanguageTechnology();
	languageTechnology.setName(createLanguageTechnologiesRequest.getName());
	
	}

	@Override
	public void delete(int id) {
	technologyRepository.deleteById(id);	
		
	}

	@Override
	public void update(UpdateLanguageTechnologiesRequest updateLanguageTechnologiesRequest) {
		LanguageTechnology languageTechnology =this.modelMapperService.forResponse()
		.map(updateLanguageTechnologiesRequest,LanguageTechnology.class);
		this.technologyRepository.save(languageTechnology);
	}


	@Override
	public GetByIdLanguageTechnologiesResponses getById(int id) {
		Optional<LanguageTechnology> languageTechnology = technologyRepository.findById(id);
		GetByIdLanguageTechnologiesResponses technologyResponse = new GetByIdLanguageTechnologiesResponses();
		technologyResponse.setName(languageTechnology.get().getName());
		return technologyResponse;
	}

}
