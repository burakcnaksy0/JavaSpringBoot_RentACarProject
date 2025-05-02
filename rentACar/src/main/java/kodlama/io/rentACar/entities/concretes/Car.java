package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan primary key
	@Column(name = "id")
	private int id;
	
	@Column(name = "plate" , unique = true)  // plaka
	private String plate;
	
	@Column(name = "dailyPrice")
	private double dailyPrice;
	
	@Column(name = "modelYear")
	private int modelYear;
	
	@Column(name = "status")  // 1 - available  2- rented  3- maintenance
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	
}













