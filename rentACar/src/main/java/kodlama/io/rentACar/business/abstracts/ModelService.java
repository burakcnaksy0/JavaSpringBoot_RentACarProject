package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	GetByIdModelsResponse byIdModelsResponse(int id);
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);
}
