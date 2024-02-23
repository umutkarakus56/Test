package Kodlama.io.demo.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "languageTechnologies")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageTechnology {

@Id
@GeneratedValue(strategy  = GenerationType.IDENTITY)

@Column(name = "languageTechnologyId")
	private int id;

@Column(name = "languageTechnologyName")
	private String name;

@ManyToOne
@JoinColumn(name = "languageId")
	private Language language;



}
