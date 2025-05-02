package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Kullanıcıdan veri almak için kullanılır. Sadece name içerir.
public class CreateBrandsRequest {
	@NotNull
	@NotBlank
	@Size(min = 3 , max = 20)
	private String name;
}


// burdaki request packageinin amamcı : 
// Dışarıdan (örneğin bir kullanıcıdan veya başka bir API'den) gelen verileri temsil eder.
// CreateBrandRequest, UpdateBrandRequest

// response packagenin amacı :
// Kullanıcıya ya da başka servislere geri döndürülen verileri temsil eder.
// GetAllBrandsResponse, GetByIdBrandResponse

// Bu ayrım, hem frontend hem de backend için veri kontrolünü kolaylaştırır.