package com.healthcare.modules.appointment.controller;


import com.healthcare.modules.appointment.dto.AppointmentResponseDTO;
import com.healthcare.modules.appointment.dto.CreateAppointmentDTO;
import com.healthcare.modules.appointment.dto.UpdateAppointmentDTO;
import com.healthcare.modules.appointment.enums.AppointmentStatus;
import com.healthcare.modules.appointment.service.AppointmentService;
import com.healthcare.modules.patient.enums.DocumentType;
import com.healthcare.shared.response.ApiResponse;
import com.healthcare.shared.response.PageResponse;
import com.healthcare.shared.response.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    // TODO
    // generar el endpoint de cancelar la cita

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AppointmentResponseDTO>> createAppointment(@Valid @RequestBody CreateAppointmentDTO createAppointmentDTO) {

        AppointmentResponseDTO appointment = appointmentService.createAppointment(createAppointmentDTO);

        return ResponseHandler.generateResponse(
                HttpStatus.CREATED,
                "Successfully created appointment",
                appointment
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<AppointmentResponseDTO>> findAppointmentById(@PathVariable UUID id) {

        AppointmentResponseDTO appointment = this.appointmentService.findAppointmentById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                appointment
        );
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<PageResponse<AppointmentResponseDTO>>> findAppointmentsFiltered(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean ascending,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) AppointmentStatus appointmentStatus,
            @RequestParam(required = false)String patientFullName,
            @RequestParam(required = false)String doctorUserName,
            @RequestParam(required = false)String patientMedicalRecordNumber,
            @RequestParam(required = false)DocumentType patientDocumentType,
            @RequestParam(required = false)String patientDocumentNumber,
            @RequestParam(required = false)String doctorSpecialty,
            @RequestParam(required = false)String doctorLicenseNumber
            ) {

        PageResponse<AppointmentResponseDTO> appointments = this.appointmentService.findAppointmentsFiltered(page, size, ascending, date, appointmentStatus, patientFullName, doctorUserName, patientMedicalRecordNumber, patientDocumentType, patientDocumentNumber, doctorSpecialty, doctorLicenseNumber);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                appointments
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<AppointmentResponseDTO>>> findAllAppointments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        PageResponse<AppointmentResponseDTO> appointments = appointmentService.findAllAppointments(page, size);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                appointments
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<AppointmentResponseDTO>> updateAppointment(@PathVariable UUID id, @Valid @RequestBody UpdateAppointmentDTO updateAppointmentDTO) {

        AppointmentResponseDTO appointmentUpdate = this.appointmentService.updateAppointment(id, updateAppointmentDTO);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                "Appointment updated successfully",
                appointmentUpdate
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteAppointmentById(@PathVariable UUID id) {

        this.appointmentService.deleteAppointment(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                "Successfully delete appointment",
                null
        );
    }

}
