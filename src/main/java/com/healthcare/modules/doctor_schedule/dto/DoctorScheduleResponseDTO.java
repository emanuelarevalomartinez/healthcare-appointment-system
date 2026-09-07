package com.healthcare.modules.doctor_schedule.dto;

import com.healthcare.modules.doctor.dto.DoctorResponseDTO;
import com.healthcare.modules.doctor_schedule.entity.DoctorScheduleEntity;
import com.healthcare.modules.doctor_schedule.enums.DoctorScheduleDay;

import java.time.LocalTime;
import java.util.UUID;

public record DoctorScheduleResponseDTO(
        UUID id,
        DoctorResponseDTO doctor,
        DoctorScheduleDay dayOfWeek,
        LocalTime startTime,
        LocalTime endTime,
        Boolean available,
        String notes

) {

    public static DoctorScheduleResponseDTO fromEntity(
            DoctorScheduleEntity schedule
    ) {

        return new DoctorScheduleResponseDTO(
                schedule.getId(),
                schedule.getDoctor() != null
                        ? DoctorResponseDTO.fromEntity(schedule.getDoctor())
                        : null,
                schedule.getDayOfWeek(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.isAvailable(),
                schedule.getNotes()
        );
    }
}
