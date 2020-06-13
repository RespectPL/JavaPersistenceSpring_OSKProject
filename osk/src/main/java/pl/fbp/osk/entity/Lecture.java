package pl.fbp.osk.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "instructor", nullable = false)
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "participant", nullable = false)
    private Participant participant;

    private String temat;
    private String date;
    private String timea;
    private Integer sumHour;

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getSumHour() {
        return sumHour;
    }

    public void setSumHour(Integer sumHour) {
        this.sumHour = sumHour;
    }

    public String getTemat() {
        return temat;
    }

    public String getTimea() {
        return timea;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public void setTimea(String timea) {
        this.timea = timea;
    }
}
