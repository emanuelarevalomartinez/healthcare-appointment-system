package com.healthcare.modules.doctor.service;

import com.healthcare.modules.doctor.dto.*;
import com.healthcare.modules.doctor.entity.DoctorEntity;
import com.healthcare.shared.response.PageResponse;

import java.util.UUID;

public interface DoctorService {
    DoctorResponseDTO createDoctor(CreateDoctorDTO createDoctorDTO);
    DoctorResponseDTO updateDoctor(UUID id, UpdateDoctorDTO updateDoctorDTO);
    DoctorResponseWithUserDTO createDoctorWithUser(CreateDoctorWithUserDTO createDoctorWithUserDTO);
    DoctorResponseWithUserDTO updateDoctorWithUser(UUID userId,UpdateDoctorWithUserDTO updateDoctorWithUserDTO);
    PageResponse<DoctorResponseDTO> findAllDoctors(int page, int size);
    DoctorResponseDTO findDoctorById(UUID id);
    PageResponse<DoctorResponseWithUserDTO> findDoctorsFiltered(int page, int size, String search);
    DoctorEntity findDoctorEntityById(UUID id);
    void deleteDoctor(UUID id);
    void deleteDoctorByUserId(UUID userId);

}
