package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

@RestController
@RequestMapping("/api/brands")
// /api/brands adresine gelen HTTP isteklerini karşılar.
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

}
