package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByOznaczenieIgnoreCase(String oznaczenie);
}
