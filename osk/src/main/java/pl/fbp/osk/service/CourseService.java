package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.repository.CourseRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Component
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
    public List<Course> findByOznaczenie(String oznaczenie) {
        return (List<Course>) courseRepository.findByOznaczenie(oznaczenie);
    }
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    public void deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
    }
    public Optional<Course> replaceCourse(Course newCourse, Long courseId) {
        return courseRepository.findById(courseId).map(course -> {
           course.setKategoria(newCourse.getKategoria());
           course.setOznaczenie(newCourse.getOznaczenie());
           return courseRepository.save(course);
        });
    }
    public Optional<Course> uodateCourse(Map<String, Object> updates, Long courseId) {
        Optional<Course> courseById = courseRepository.findById(courseId);
        if(courseById.isPresent()) {
            Course course = courseById.get();
            if(updates.containsKey("kategoria")) {
                course.setKategoria((String) updates.get("kategoria"));
            }
            if(updates.containsKey("oznaczenie")) {
                course.setOznaczenie((String) updates.get("oznaczenie"));
            }
            courseRepository.save(course);
        }
        return courseById;
    }
}
