package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.DrivingLesson;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.repository.DrivingLessonRepository;

import java.util.List;
import java.util.Map;
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
    public List<DrivingLesson> findByInstructor(Instructor instructor) {
        return drivingLessonRepository.findByInstructor(instructor);
    }
    public Optional<DrivingLesson> updateDrivingLesson(Map<String, Object> updates, Long drivingLessonId) {
        Optional<DrivingLesson> drivingLessonById = drivingLessonRepository.findById(drivingLessonId);
        if(drivingLessonById.isPresent()) {
            DrivingLesson drivingLesson = drivingLessonById.get();
            if(updates.containsKey("date")) {
                drivingLesson.setDate((String) updates.get("date"));
            }
            if(updates.containsKey("time")) {
                drivingLesson.setTime((String) updates.get("time"));
            }
            if(updates.containsKey("sumHour")) {
                drivingLesson.setSumHour((Integer) updates.get("sumHour"));
            }
            drivingLessonRepository.save(drivingLesson);
        }
        return drivingLessonById;
    }
    public void deleteById(Long drivingLessonId) {
        drivingLessonRepository.deleteById(drivingLessonId);
    }
}
