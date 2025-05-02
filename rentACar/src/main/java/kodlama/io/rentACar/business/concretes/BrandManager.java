package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;

//bu class bir business nesnesidir
//Bu class BrandService'i implement eder ve iş kurallarını içerir.
@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;  // Entity ↔ DTO dönüşümleri yapılır.
	private BrandBusinessRules brandBusinessRules;

	// Veritabanından Brand nesneleri alınır ve GetAllBrandsResponse'a çevrilir
	@Override
	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları
		List<Brand> brands = brandRepository.findAll();
		/*
		 * List<GetAllBrandsResponse> allBrandsResponses = new
		 * ArrayList<GetAllBrandsResponse>();
		 * 
		 * for (Brand brand : brands) { GetAllBrandsResponse responseItem = new
		 * GetAllBrandsResponse(); responseItem.setId(brand.getId());
		 * responseItem.setName(brand.getName()); allBrandsResponses.add(responseItem);
		 * 
		 * }
		 */
		List<GetAllBrandsResponse> allBrandsResponses = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return allBrandsResponses;
	}

	// Request'ten gelen marka ismi alınıp veritabanına kaydedilir
	@Override
	public void add(CreateBrandsRequest createBrandsRequest) {
		// Brand brand = new Brand();
		// brand.setName(createBrandsRequest.getName());
		this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest, Brand.class);

		this.brandRepository.save(brand);

	}

	/*
	 * @Override public Brand getBrandById(int id) { Optional<Brand> getBrand =
	 * brandRepository.findById(id); // dönüştürmüş oluyorsun. return
	 * getBrand.orElseThrow(() -> new RuntimeException("Brand not found")); }
	 * 
	 * 
	 * 
	 * @Override public Brand updateBrand(int id, Brand updatedUser) { Brand brand =
	 * brandRepository.findById(id).orElseThrow(() -> new
	 * RuntimeException("Brand not found")); brand.setId(updatedUser.getId());
	 * brand.setName(updatedUser.getName());
	 * 
	 * return brandRepository.save(brand); }
	 */
	@Override
	public void deleteBrand(int id) {
		brandRepository.deleteById(id);

	}

	@Override
	public GetByIdBrandResponse byIdBrandResponse(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

}
