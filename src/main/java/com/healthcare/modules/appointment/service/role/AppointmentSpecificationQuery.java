package com.healthcare.modules.appointment.service.role;

import com.healthcare.modules.appointment.entity.AppointmentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public record AppointmentSpecificationQuery(Specification<AppointmentEntity> specification, Pageable pageable) {
}
