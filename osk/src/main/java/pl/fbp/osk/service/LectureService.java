package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Lecture;
import pl.fbp.osk.repository.LectureRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> findAll() {
        return (List<Lecture>) lectureRepository.findAll();
    }
    public Optional<Lecture> findById(Long id) {
        return lectureRepository.findById(id);
    }
}
