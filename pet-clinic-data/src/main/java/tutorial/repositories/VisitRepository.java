package tutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
