package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Participant;
import pl.fbp.osk.repository.ParticipantRepository;

import java.util.List;
import java.util.Map;
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
    public Optional<Participant> updateParticipant(Map<String, Object> updates, Long participantId) {
        Optional<Participant> participantById = participantRepository.findById(participantId);
        if(participantById.isPresent()) {
            Participant participant = participantById.get();
            if(updates.containsKey("imie")) {
                participant.setImie((String) updates.get("imie"));
            }
            if(updates.containsKey("nazwisko")) {
                participant.setNazwisko((String) updates.get("nazwisko"));
            }
            if(updates.containsKey("pesel")) {
                participant.setPesel((String) updates.get("pesel"));
            }
            if(updates.containsKey("telefon")) {
                participant.setTelefon((String) updates.get("telefon"));
            }
            if(updates.containsKey("pkk")) {
                participant.setPkk((String) updates.get("pkk"));
            }
            participantRepository.save(participant);
        }
        return participantById;
    }
}
