package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.InternalExam;
import pl.fbp.osk.entity.Participant;

import java.util.List;

public interface InternalExamRepository extends CrudRepository<InternalExam, Long> {
    List<InternalExam> findByParticipant(Participant participant);
}
