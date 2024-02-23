package Kodlama.io.demo.business.requests.languageTechnologies;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteLanguageTechnologiesRequest {

@NotBlank
@NotNull
	
	private int id;

}
