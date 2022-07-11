package tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
