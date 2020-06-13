package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.CourseData;

public interface CourseDataRepository extends CrudRepository<CourseData, Long> {
}
