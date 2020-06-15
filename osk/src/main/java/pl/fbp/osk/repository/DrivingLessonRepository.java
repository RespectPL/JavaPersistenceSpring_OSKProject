package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.DrivingLesson;
import pl.fbp.osk.entity.Instructor;

import java.util.List;

public interface DrivingLessonRepository extends CrudRepository<DrivingLesson, Long> {
    List<DrivingLesson> findByInstructor(Instructor instructor);
}
