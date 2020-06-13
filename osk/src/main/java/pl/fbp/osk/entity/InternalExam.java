package pl.fbp.osk.entity;

import javax.persistence.*;

@Entity
public class InternalExam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "instructor", nullable = false)
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "participant", nullable = false)
    private Participant participant;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "course", nullable = false)
    private Course course;

    private String date;
    private String time;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Course getCourse() {
        return course;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
