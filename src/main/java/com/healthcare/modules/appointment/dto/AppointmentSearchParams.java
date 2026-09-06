package com.healthcare.modules.appointment.dto;

import com.healthcare.modules.appointment.enums.AppointmentStatus;
import com.healthcare.modules.patient.enums.DocumentType;

public record AppointmentSearchParams(
        int page,
        int size,
        boolean ascending,
        String searchTerm,
        AppointmentStatus appointmentStatus,
        DocumentType documentType
) {
}
