package com.healthcare.modules.appointment.service;

import com.healthcare.modules.appointment.dto.AppointmentResponseDTO;
import com.healthcare.modules.appointment.dto.CreateAppointmentDTO;
import com.healthcare.modules.appointment.dto.UpdateAppointmentDTO;
import com.healthcare.modules.appointment.entity.AppointmentEntity;
import com.healthcare.modules.appointment.enums.AppointmentStatus;
import com.healthcare.modules.patient.enums.DocumentType;
import com.healthcare.shared.response.PageResponse;

import java.time.LocalDate;
import java.util.UUID;

public interface AppointmentService {
    AppointmentResponseDTO createAppointment(CreateAppointmentDTO createAppointmentDTO);

    AppointmentResponseDTO updateAppointment(UUID id, UpdateAppointmentDTO updateAppointmentDTO);

    PageResponse<AppointmentResponseDTO> findAllAppointments(int page, int size);

    AppointmentResponseDTO findAppointmentById(UUID id);

    PageResponse<AppointmentResponseDTO> findAppointmentsFiltered(int page, int size, boolean ascending, LocalDate date, AppointmentStatus appointmentStatus, String patientFullName, String doctorUserName, String patientMedicalRecordNumber, DocumentType patientDocumentType, String patientDocumentNumber, String doctorSpecialty, String doctorLicenseNumber);

    PageResponse<AppointmentResponseDTO> searchAppointments(int page, int size, boolean ascending, String searchTerm, AppointmentStatus appointmentStatus, DocumentType documentType);

    AppointmentEntity findAppointmentEntityById(UUID id);

    void deleteAppointment(UUID id);

}
