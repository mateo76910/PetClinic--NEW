package tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
