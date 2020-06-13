package pl.fbp.osk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String typ;
    private String nazwa;
    private String nrRejestracyjny;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DrivingLesson> drivingLessons;

    public void setDrivingLessons(Set<DrivingLesson> drivingLessons) {
        this.drivingLessons = drivingLessons;
    }

    public Set<DrivingLesson> getDrivingLessons() {
        return drivingLessons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public String getTyp() {
        return typ;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny = nrRejestracyjny;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
