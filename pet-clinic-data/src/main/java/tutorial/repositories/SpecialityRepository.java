package tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
