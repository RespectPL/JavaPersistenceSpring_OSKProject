package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
