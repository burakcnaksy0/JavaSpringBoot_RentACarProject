package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Kullanıcıdan veri almak için kullanılır. Sadece name içerir.
// Kullanıcıdan gelen veriyi tutar (DTO)(Data Transfer Object)
// DTO'lar sadece veri alışverişi içindir. Veritabanıyla doğrudan ilişkili değildir.
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandsRequest {
	@NotBlank
	private String name;

}
