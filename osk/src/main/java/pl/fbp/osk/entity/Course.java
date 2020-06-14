package pl.fbp.osk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String oznaczenie;
    private String kategoria;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "c_cd")
    private Set<CourseData> courseData;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "c_dl")
    private Set<DrivingLesson> drivingLessons;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "c_ie")
    private Set<InternalExam> internalExams;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setOznaczenie(String oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }

    public String getKategoria() {
        return kategoria;
    }

    public Set<CourseData> getCourseData() {
        return courseData;
    }

    public Set<DrivingLesson> getDrivingLessons() {
        return drivingLessons;
    }

    public Set<InternalExam> getInternalExams() {
        return internalExams;
    }

    public void setCourseData(Set<CourseData> courseData) {
        this.courseData = courseData;
    }

    public void setDrivingLessons(Set<DrivingLesson> drivingLessons) {
        this.drivingLessons = drivingLessons;
    }

    public void setInternalExams(Set<InternalExam> internalExams) {
        this.internalExams = internalExams;
    }
}
