package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.repository.InstructorRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Component
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }
    public Optional<Instructor> findById(Long id) {
        return instructorRepository.findById(id);
    }
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    public void deleteById(Long instructorId) {
        instructorRepository.deleteById(instructorId);
    }
    public Optional<Instructor> replaceInstructor(Instructor newInstructor, Long instructorId) {
        return instructorRepository.findById(instructorId).map(instructor -> {
            instructor.setImie(newInstructor.getImie());
            instructor.setNazwisko(newInstructor.getNazwisko());
            return instructorRepository.save(instructor);
        });
    }
    public Optional<Instructor> updateInstructor(Map<String, Object> updates, Long instructorId) {
        Optional<Instructor> instructorById = instructorRepository.findById(instructorId);
        if(instructorById.isPresent()) {
            Instructor instructor = instructorById.get();
            if(updates.containsKey("imie")) {
                instructor.setImie((String) updates.get("imie"));
            }
            if(updates.containsKey("nazwisko")) {
                instructor.setNazwisko((String) updates.get("nazwisko"));
            }
            instructorRepository.save(instructor);
        }
        return instructorById;
    }
}
