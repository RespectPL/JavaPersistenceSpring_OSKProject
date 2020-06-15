package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.entity.CourseData;

import java.util.List;

public interface CourseDataRepository extends CrudRepository<CourseData, Long> {
    List<CourseData> findByPaidIsTrue();
    List<CourseData> findByPaidIsFalse();
    List<CourseData> findByCourse(Course course);
}
