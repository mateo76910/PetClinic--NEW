package tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
