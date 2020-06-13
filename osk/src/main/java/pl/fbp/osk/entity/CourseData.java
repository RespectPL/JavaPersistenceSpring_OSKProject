package pl.fbp.osk.entity;

import javax.persistence.*;

@Entity
public class CourseData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "participant", nullable = false)
    private Participant participant;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "course", nullable = false)
    private Course course;

    private Boolean paid;
    private Boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Boolean getPaid() {
        return paid;
    }

    public Course getCourse() {
        return course;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
