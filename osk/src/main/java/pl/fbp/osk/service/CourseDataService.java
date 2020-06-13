package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
}
