package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.service.InstructorService;

import java.util.List;
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
}
