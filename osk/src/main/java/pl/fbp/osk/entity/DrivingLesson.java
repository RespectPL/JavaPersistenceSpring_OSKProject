package pl.fbp.osk.entity;

import javax.persistence.*;

@Entity
public class DrivingLesson {
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vehicle", nullable = false)
    private Vehicle vehicle;

    private String date;
    private String time;
    private Integer sumHour;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Integer getSumHour() {
        return sumHour;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setSumHour(Integer sumHour) {
        this.sumHour = sumHour;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
