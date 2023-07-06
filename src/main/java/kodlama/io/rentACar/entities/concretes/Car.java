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
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "plate", unique = true)
	private String plate;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "state")
	private int state; 	//1-)available 2-)rented 3->maintanence
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
}
