package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.entities.concretes.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
	boolean existsByName(String name);
}
