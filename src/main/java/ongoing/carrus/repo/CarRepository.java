package ongoing.carrus.repo;

import ongoing.carrus.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Integer> {
}
