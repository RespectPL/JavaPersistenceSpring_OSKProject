package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.DrivingLesson;
import pl.fbp.osk.repository.DrivingLessonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class DrivingLessonService {
    @Autowired
    private DrivingLessonRepository drivingLessonRepository;

    public List<DrivingLesson> findAll() {
        return (List<DrivingLesson>) drivingLessonRepository.findAll();
    }
    public Optional<DrivingLesson> findById(Long id) {
        return drivingLessonRepository.findById(id);
    }
    public DrivingLesson createDrivingLesson(DrivingLesson drivingLesson) {
        return drivingLessonRepository.save(drivingLesson);
    }
}
