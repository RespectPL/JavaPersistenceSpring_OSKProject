package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.*;
import pl.fbp.osk.service.CourseService;
import pl.fbp.osk.service.InstructorService;
import pl.fbp.osk.service.InternalExamService;
import pl.fbp.osk.service.ParticipantService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/osk/internal_exams")
public class InternalExamController {
    @Autowired
    private InternalExamService internalExamService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<InternalExam>> getAllInternalExams() {
        return ResponseEntity.ok(internalExamService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<InternalExam> getInternalExamById(@PathVariable Long id) {
        Optional<InternalExam> internalExam = internalExamService.findById(id);
        return ResponseEntity.ok(internalExam.get());
    }
    @GetMapping(value = "/participant/{participantId}/check_internal_exam")
    public ResponseEntity<String> getCheckInternalExamByParticipant(@PathVariable Long participantId) {
        Optional<Participant> getparticipant = participantService.findById(participantId);
        boolean check = false;
        if(getparticipant.isPresent()) {
            Participant participant = getparticipant.get();
            List<InternalExam> iep = internalExamService.findByParticipant(participant);
            String exams = "";
            for(InternalExam ie : iep) {
                check = true;
                exams += "Jestes wzywany na egzamin wewnetrzny z kursu " + ie.getCourse().getOznaczenie() + "/" + ie.getCourse().getKategoria() +"\n";
            }
            return ResponseEntity.ok(exams);
        }
        else {
            return ResponseEntity.ok("Brak takiego kursanta");
        }
    }

    @PostMapping("/instructor/{instructorId}/determine_exam/{participantId}/course/{courseId}")
    public InternalExam newInternalExam(@PathVariable(value = "instructorId") Long instructorId,
                                        @PathVariable(value = "participantId") Long participantId,
                                        @PathVariable(value = "courseId") Long courseId,
                                        @RequestBody InternalExam internalExam) {
        Optional<Instructor> instructor = instructorService.findById(instructorId);
        internalExam.setInstructor(instructor.get());
        Optional<Participant> participant = participantService.findById(participantId);
        internalExam.setParticipant(participant.get());
        Optional<Course> course = courseService.findById(courseId);
        internalExam.setCourse(course.get());
        return internalExamService.createInternalExam(internalExam);
    }

    @PatchMapping("/instructor/update/{internalExamId}")
    public ResponseEntity<InternalExam> updateInternalExam(@RequestBody Map<String, Object> updates,
                                                           @PathVariable Long internalExamId) {
        Optional<InternalExam> updatedInternalExam = internalExamService.updateInternalExam(updates, internalExamId);
        return ResponseEntity.of(updatedInternalExam);
    }

    @DeleteMapping("/instructor/delete/{internalExamId}")
    public void deleteInternalExam(@PathVariable long internalExamId) {
        internalExamService.deleteById(internalExamId);
    }
}
