package Kodlama.io.demo.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import Kodlama.io.demo.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer>{
	
	public boolean getByName(boolean name);

}
