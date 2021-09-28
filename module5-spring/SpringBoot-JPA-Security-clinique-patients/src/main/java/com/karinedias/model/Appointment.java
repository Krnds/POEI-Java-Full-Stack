package com.karinedias.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rdv")
public class Appointment {

    private int id;
    private Patient idPatient;
    private Timestamp date;
    private String type;
    private int duration;
    private String note;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id")
    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && duration == that.duration && idPatient.equals(that.idPatient) && date.equals(that.date) && type.equals(that.type) && note.equals(that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPatient, date, type, duration, note);
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", idPatient=" + idPatient +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                ", note='" + note + '\'' +
                '}';
    }
}
