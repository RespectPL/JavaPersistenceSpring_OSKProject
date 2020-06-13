package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
}
