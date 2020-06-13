package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Course;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByOznaczenie(String oznaczenie);
}
