package pl.fbp.osk.repository;

import org.springframework.data.repository.CrudRepository;
import pl.fbp.osk.entity.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
}
