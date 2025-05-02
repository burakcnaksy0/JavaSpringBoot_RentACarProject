package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok, Java projelerinde tekrarlı (boilerplate) kodları ortadan kaldırmak için kullanılan bir Java kütüphanesidir.s
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand { // @Entity anotasyonu sayesinde bu sınıf veritabanındaki brands tablosuna
						// karşılık gelir.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan primary key
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "brand")   // one brand has many models
	private List<Model> models; // bir markanın birden fazla modeli olabilir (BMW -> X2. , i4 , M440i xDRIVE CABRIO)
						

}

// brand --> id, name , quantity
// GetAllBrandsResponse --> id , name

// mapping
