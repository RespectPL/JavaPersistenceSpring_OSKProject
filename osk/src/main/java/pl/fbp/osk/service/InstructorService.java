package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.repository.InstructorRepository;

import java.util.List;
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
}
