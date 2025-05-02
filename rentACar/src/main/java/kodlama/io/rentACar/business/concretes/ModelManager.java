package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
				
		return modelsResponses;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
	    Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);

	    // ID'yi manuel olarak sıfırla, Hibernate bunu yeni nesne olarak algılasın
	    // Hibernate’e “bu yeni bir nesne, güncelleme yapma” sinyali verilir.
	    // Yoksa save() metodu, aynı ID varsa güncelleme yapabilir.
	    model.setId(0); 

	    Brand brand = new Brand();
	    brand.setId(createModelRequest.getBrandId());
	    model.setBrand(brand);

	    this.modelRepository.save(model);
	}

	@Override
	public GetByIdModelsResponse byIdModelsResponse(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();
		GetByIdModelsResponse response = this.modelMapperService.forResponse().map(model,GetByIdModelsResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		
		this.modelRepository.save(model);
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
	}

	



}
