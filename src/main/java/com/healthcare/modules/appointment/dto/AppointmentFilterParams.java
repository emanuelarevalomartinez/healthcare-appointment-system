package com.healthcare.modules.appointment.dto;

import com.healthcare.modules.appointment.enums.AppointmentStatus;
import com.healthcare.modules.patient.enums.DocumentType;

import java.time.LocalDate;

public record AppointmentFilterParams(
        int page,
        int size,
        boolean ascending,
        LocalDate date,
        AppointmentStatus appointmentStatus,
        String patientFullName,
        String doctorUserName,
        String patientMedicalRecordNumber,
        DocumentType patientDocumentType,
        String patientDocumentNumber,
        String doctorSpecialty,
        String doctorLicenseNumber
) {}
