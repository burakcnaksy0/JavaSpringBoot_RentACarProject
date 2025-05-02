package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/brands")   //    /api/brands adresine gelen HTTP isteklerini karşılar.
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateBrandsRequest brandsRequest) {
		this.brandService.add(brandsRequest);
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.byIdBrandResponse(id);
	}
	
	@PutMapping("/{id}")
	public void update(UpdateBrandRequest brandRequest) {
		this.brandService.update(brandRequest);
	}
	/*
	@GetMapping("/{id}")
	public Brand getBrandById(int id) {
		return brandService.getBrandById(id);
	}
	
	@PutMapping("/{id}")
	public Brand updateBrand(int id, Brand updatedUser) {
		return brandService.updateBrand(id, updatedUser);
	}
	*/
	@DeleteMapping("/{id}")
	public void deleteBrand(@PathVariable int id) {
		brandService.deleteBrand(id);
	}
	 

}
