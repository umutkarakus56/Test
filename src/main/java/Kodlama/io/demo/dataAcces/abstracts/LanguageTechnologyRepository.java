package Kodlama.io.demo.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.demo.entities.concretes.LanguageTechnology;

public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology, Integer> {

}
