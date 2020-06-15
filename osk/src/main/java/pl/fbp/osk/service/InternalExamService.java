package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.InternalExam;
import pl.fbp.osk.repository.InternalExamRepository;

import java.util.List;
import java.util.Map;
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
    public InternalExam createInternalExam(InternalExam internalExam) {
        return internalExamRepository.save(internalExam);
    }
    public void deleteById(Long internalExamId) {
        internalExamRepository.deleteById(internalExamId);
    }
    public Optional<InternalExam> updateInternalExam(Map<String, Object> updates, Long internalExamId) {
        Optional<InternalExam> internalExamById = internalExamRepository.findById(internalExamId);
        if(internalExamById.isPresent()) {
            InternalExam internalExam = internalExamById.get();
            if(updates.containsKey("date")) {
                internalExam.setDate((String) updates.get("date"));
            }
            if(updates.containsKey("time")) {
                internalExam.setTime((String) updates.get("time"));
            }
            internalExamRepository.save(internalExam);
        }
        return internalExamById;
    }
}
