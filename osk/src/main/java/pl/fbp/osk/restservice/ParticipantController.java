package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.Participant;
import pl.fbp.osk.service.ParticipantService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/osk/participants")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Participant>> getAllParticipants() {
        return ResponseEntity.ok(participantService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) {
        Optional<Participant> participant = participantService.findById(id);
        return ResponseEntity.ok(participant.get());
    }

    @PostMapping("/register")
    public Participant newParticipant(@RequestBody Participant participant) {
        return participantService.createParticipant(participant);
    }

    @PatchMapping("update_data/{participantId}")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Map<String, Object> updates,
                                                         @PathVariable Long participantId) {
        Optional<Participant> updatedParticipant = participantService.updateParticipant(updates, participantId);
        return ResponseEntity.of(updatedParticipant);
    }
}
