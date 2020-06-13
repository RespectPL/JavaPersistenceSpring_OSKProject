package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.repository.CourseRepository;

import java.util.List;
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
}
