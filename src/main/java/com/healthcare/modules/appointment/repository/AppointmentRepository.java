package com.healthcare.modules.appointment.repository;

import com.healthcare.modules.appointment.entity.AppointmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID>, JpaSpecificationExecutor<AppointmentEntity> {

    @Query("SELECT a FROM AppointmentEntity a")
    Page<AppointmentEntity> findAllAppointmentsPaged(Pageable pageable);

}
