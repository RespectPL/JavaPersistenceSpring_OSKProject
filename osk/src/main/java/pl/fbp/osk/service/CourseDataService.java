package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.entity.CourseData;
import pl.fbp.osk.repository.CourseDataRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CourseDataService {
    @Autowired
    private CourseDataRepository courseDataRepository;

    public List<CourseData> findAll() {
        return (List<CourseData>) courseDataRepository.findAll();
    }
    public Optional<CourseData> findById(Long id) {
        return courseDataRepository.findById(id);
    }
    public CourseData createCourseData(CourseData courseData) {
        return courseDataRepository.save(courseData);
    }
    public List<CourseData> findByCourse(Course course) {
        return courseDataRepository.findByCourse(course);
    }
    public List<CourseData> findByPaid(String paid) {
        if(paid.equals("true")) {
            return courseDataRepository.findByPaidIsTrue();
        }
        else if(paid.equals("false")) {
            return courseDataRepository.findByPaidIsFalse();
        }
        else {
            return (List<CourseData>) courseDataRepository.findAll();
        }
    }
}
