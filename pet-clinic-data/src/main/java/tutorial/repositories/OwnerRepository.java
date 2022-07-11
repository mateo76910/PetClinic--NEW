package tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
}
