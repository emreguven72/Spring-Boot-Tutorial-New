package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
		
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class); //this also changes model's id(Bug)
		model.setId(0); //the solution for the bug above
		
		this.modelRepository.save(model);
	}
}
