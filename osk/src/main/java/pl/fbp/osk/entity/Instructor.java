package pl.fbp.osk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String imie;
    private String nazwisko;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Lecture> lectures;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DrivingLesson> drivingLessons;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<InternalExam> internalExams;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInternalExams(Set<InternalExam> internalExams) {
        this.internalExams = internalExams;
    }

    public void setDrivingLessons(Set<DrivingLesson> drivingLessons) {
        this.drivingLessons = drivingLessons;
    }

    public Set<InternalExam> getInternalExams() {
        return internalExams;
    }

    public Set<DrivingLesson> getDrivingLessons() {
        return drivingLessons;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }
}
