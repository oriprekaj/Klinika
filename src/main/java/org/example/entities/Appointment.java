package org.example.entities;

import jakarta.persistence.*;
import org.example.static_data.Status;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientName='" + patientName + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", beginAt=" + beginAt +
                ", endAt=" + endAt +
                ", report=" + report +
                '}';
    }
// removed doctor from to string qe mos te shfaqet ne console
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private String patientName;
    private String note;

    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime beginAt;
    private LocalDateTime endAt;
    @ManyToOne
    @JoinColumn(name = "doctor_ID")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "report_Id")
    private Report report;


    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(LocalDateTime beginAt) {
        this.beginAt = beginAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
