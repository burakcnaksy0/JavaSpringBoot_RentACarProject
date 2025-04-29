package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.entities.concretes.Brand;


@RestController
@RequestMapping("/api/brands")   //    /api/brands adresine gelen HTTP isteklerini karşılar.
public class BrandsController {
	private BrandService brandService;

	
	@Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

	@GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
	@PostMapping("/add")
	public void add(CreateBrandsRequest brandsRequest) {
		this.brandService.add(brandsRequest);
	}
	
	@GetMapping("/{id}")
	public Brand getBrandById(int id) {
		return brandService.getBrandById(id);
	}
	
	@PutMapping("/{id}")
	public Brand updateBrand(int id, Brand updatedUser) {
		return brandService.updateBrand(id, updatedUser);
	}
	@DeleteMapping("/{id}")
	public void deleteBrand(int id) {
		brandService.deleteBrand(id);
	}
	 

}
