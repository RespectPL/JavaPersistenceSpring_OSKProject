package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.DrivingLesson;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.entity.Participant;

import java.util.List;

public interface DrivingLessonRepository extends CrudRepository<DrivingLesson, Long> {
    List<DrivingLesson> findByInstructor(Instructor instructor);
    List<DrivingLesson> findByParticipant(Participant participant);
}
