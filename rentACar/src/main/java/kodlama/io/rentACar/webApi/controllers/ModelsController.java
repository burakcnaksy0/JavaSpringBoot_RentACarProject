package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models") // /api/models adresine gelen HTTP isteklerini karşılar.
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;

	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return modelService.getAll();
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateModelRequest modelRequest) {
		this.modelService.add(modelRequest);
	}
	
	@GetMapping("/{id}")
	public GetByIdModelsResponse getById(@PathVariable int id) {
		return modelService.byIdModelsResponse(id);
	}
	
	@PutMapping("/{id}")
	public void update(UpdateModelRequest modelRequest) {
		this.modelService.update(modelRequest);
	}
	@DeleteMapping("/{id}")
	public void deleteBrand(@PathVariable int id) {
		modelService.delete(id);
	}
	 
	 
}
