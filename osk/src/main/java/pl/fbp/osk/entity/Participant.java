package pl.fbp.osk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String imie;
    private String nazwisko;
    private String pesel;
    private String telefon;
    private String pkk;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<CourseData> courseData;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Lecture> lectures;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DrivingLesson> drivingLessons;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<InternalExam> internalExams;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<DrivingLesson> getDrivingLessons() {
        return drivingLessons;
    }

    public Set<InternalExam> getInternalExams() {
        return internalExams;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setDrivingLessons(Set<DrivingLesson> drivingLessons) {
        this.drivingLessons = drivingLessons;
    }

    public void setInternalExams(Set<InternalExam> internalExams) {
        this.internalExams = internalExams;
    }

    public void setCourseData(Set<CourseData> courseData) {
        this.courseData = courseData;
    }

    public Set<CourseData> getCourseData() {
        return courseData;
    }

    public void setPkk(String pkk) {
        this.pkk = pkk;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getPkk() {
        return pkk;
    }

    public String getPesel() {
        return pesel;
    }
}
