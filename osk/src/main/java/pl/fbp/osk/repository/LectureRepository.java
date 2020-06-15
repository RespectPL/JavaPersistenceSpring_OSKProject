package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.entity.Lecture;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findByInstructor(Instructor instructor);
}
