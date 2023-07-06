package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
	private ModelRepository modelRepository;
	
	public void checkIfModelNameExists(String name) {
		if(this.modelRepository.existsByName(name)) {
			throw new BusinessException("Model name already exists!");
		}
	}
	
}
