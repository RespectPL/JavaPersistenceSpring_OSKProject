package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
