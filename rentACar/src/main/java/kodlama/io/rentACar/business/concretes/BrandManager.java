package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

//bu class bir business nesnesidir
//Bu class BrandService'i implement eder ve iş kurallarını içerir.
@Service 
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;

	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	// Veritabanından Brand nesneleri alınır ve GetAllBrandsResponse'a çevrilir
	@Override
	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> allBrandsResponses = new ArrayList<GetAllBrandsResponse>();

		for (Brand brand : brands) {
			GetAllBrandsResponse brandsResponse = new GetAllBrandsResponse();
			brandsResponse.setId(brand.getId());
			brandsResponse.setName(brand.getName());
			allBrandsResponses.add(brandsResponse);

		}

		return allBrandsResponses;
	}

	// Request'ten gelen marka ismi alınıp veritabanına kaydedilir
	@Override
	public void add(CreateBrandsRequest createBrandsRequest) {
		Brand brand = new Brand();

		brand.setName(createBrandsRequest.getName());

		this.brandRepository.save(brand);

	}

	@Override
	public Brand getBrandById(int id) {
		Optional<Brand> getBrand = brandRepository.findById(id);																		// dönüştürmüş oluyorsun.
		return getBrand.orElseThrow(() -> new RuntimeException("Brand not found"));
	}

	@Override
	public Brand updateBrand(int id, Brand updatedUser) {
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
		brand.setId(updatedUser.getId());
		brand.setName(updatedUser.getName());

		return brandRepository.save(brand);
	}

	@Override
	public void deleteBrand(int id) {
		brandRepository.deleteById(id);

	}

}
