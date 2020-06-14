package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.service.InstructorService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/osk/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Optional<Instructor> instructor = instructorService.findById(id);
        return ResponseEntity.ok(instructor.get());
    }

    @PostMapping("/add")
    public Instructor newInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Instructor> replaceInstructor(@RequestBody Instructor instructor, @PathVariable Long id) {
        Optional<Instructor> replacedInstructor = instructorService.replaceInstructor(instructor, id);
        return ResponseEntity.of(replacedInstructor);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        Optional<Instructor> updatedInstructor = instructorService.updateInstructor(updates, id);
        return ResponseEntity.of(updatedInstructor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInstructor(@PathVariable long id) {
        instructorService.deleteById(id);
    }
}
