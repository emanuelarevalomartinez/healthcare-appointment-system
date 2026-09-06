package com.healthcare.modules.doctor_schedule.entity;

import com.healthcare.modules.doctor.entity.DoctorEntity;
import com.healthcare.modules.doctor_schedule.enums.DoctorScheduleDay;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalTime;

@Entity
@Table(
        name = "doctor_schedule"
)
public class DoctorScheduleEntity {

    @Id
    @UuidGenerator
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UuidGenerator id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "doctor_id",
            nullable = false
    )
    private DoctorEntity doctor;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false, length = 10)
    private DoctorScheduleDay dayOfWeek;

    @Column(
            name = "start_time",
            nullable = false
    )
    private LocalTime startTime;

    @Column(
            name = "end_time",
            nullable = false
    )
    private LocalTime endTime;

    @Column(
            name = "available",
            nullable = false
    )
    private boolean available;

    @Column(
            name = "notes",
            length = 500
    )
    private String notes;

    public DoctorScheduleEntity() {
    }

    public UuidGenerator getId() {
        return id;
    }

    public void setId(UuidGenerator id) {
        this.id = id;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public DoctorScheduleDay getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DoctorScheduleDay dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
