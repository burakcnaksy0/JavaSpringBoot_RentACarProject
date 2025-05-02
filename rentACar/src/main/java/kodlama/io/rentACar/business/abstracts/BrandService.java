package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

// Bir interface’tir. Servisin dış dünyaya ne sunacağını tanımlar.
// CRUD işlemleri iş mantığını genellikle Service katmanında gerçekleştiririz. 
// Bu katman, repository'yi çağırarak veritabanı işlemlerini gerçekleştirir.
public interface BrandService {
	List<GetAllBrandsResponse> getAll(); // Read (Find All) -> hepsini döndüreceği için bir liste şeklinde ifade edilir.
	GetByIdBrandResponse byIdBrandResponse(int id); // Read (Find by ID) -> sadece id ye göre bir değer döndürür.
	void add(CreateBrandsRequest createBrandsRequest); 
	void update(UpdateBrandRequest updateBrandRequest); // Update
	public void deleteBrand(int id); // Delete
	//public Brand getBrandById(int id); // Read (Find by ID)
	//public Brand updateBrand(int id, Brand updatedUser); // Update
	
	
}
