package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

// Bir interface’tir. Servisin dış dünyaya ne sunacağını tanımlar.
public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandsRequest createBrandsRequest);
}
