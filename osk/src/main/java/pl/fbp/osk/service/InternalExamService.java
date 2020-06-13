package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.InternalExam;
import pl.fbp.osk.repository.InternalExamRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class InternalExamService {
    @Autowired
    private InternalExamRepository internalExamRepository;

    public List<InternalExam> findAll() {
        return (List<InternalExam>) internalExamRepository.findAll();
    }
    public Optional<InternalExam> findById(Long id) {
        return internalExamRepository.findById(id);
    }
}
