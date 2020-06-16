package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.entity.Lecture;
import pl.fbp.osk.entity.Participant;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findByInstructor(Instructor instructor);
    List<Lecture> findByParticipant(Participant participant);
}
