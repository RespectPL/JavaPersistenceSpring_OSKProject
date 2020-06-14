package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Participant;
import pl.fbp.osk.repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> findAll() {
        return (List<Participant>) participantRepository.findAll();
    }
    public Optional<Participant> findById(Long id) {
        return participantRepository.findById(id);
    }
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
}
