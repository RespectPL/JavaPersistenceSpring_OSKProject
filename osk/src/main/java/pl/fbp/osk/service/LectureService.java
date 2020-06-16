package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Instructor;
import pl.fbp.osk.entity.Lecture;
import pl.fbp.osk.entity.Participant;
import pl.fbp.osk.repository.LectureRepository;

import java.util.List;
import java.util.Map;
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
    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }
    public List<Lecture> findByInstructor(Instructor instructor) {
        return lectureRepository.findByInstructor(instructor);
    }
    public List<Lecture> findByParticipant(Participant participant) {
        return lectureRepository.findByParticipant(participant);
    }
    public Optional<Lecture> updateLecture(Map<String, Object> updates, Long lectureId) {
        Optional<Lecture> lectureById = lectureRepository.findById(lectureId);
        if(lectureById.isPresent()) {
            Lecture lecture = lectureById.get();
            if(updates.containsKey("temat")) {
                lecture.setTemat((String) updates.get("temat"));
            }
            if(updates.containsKey("date")) {
                lecture.setDate((String) updates.get("date"));
            }
            if(updates.containsKey("timea")) {
                lecture.setTimea((String) updates.get("timea"));
            }
            if(updates.containsKey("sumHour")) {
                lecture.setSumHour((Integer) updates.get("sumHour"));
            }
            lectureRepository.save(lecture);
        }
        return lectureById;
    }
    public void deleteById(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }
}
