package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Kullanıcıdan veri almak için kullanılır. Sadece name içerir.
public class CreateBrandsRequest {
	private String name;

}
