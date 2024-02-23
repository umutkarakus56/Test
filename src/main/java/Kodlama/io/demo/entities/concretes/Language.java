package Kodlama.io.demo.entities.concretes;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Language {
@Id
@GeneratedValue(strategy  = GenerationType.IDENTITY)

@Column(name = "languageId")
		private int id;
		
@Column(name = "languageName")
		private String name;
		
@OneToMany(mappedBy = "language")
	private List<LanguageTechnology> languageTechnologies;

}
