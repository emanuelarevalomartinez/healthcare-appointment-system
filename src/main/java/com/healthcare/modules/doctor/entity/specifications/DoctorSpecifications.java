package com.healthcare.modules.doctor.entity.specifications;

import com.healthcare.modules.doctor.entity.DoctorEntity;
import com.healthcare.modules.user.entity.UserEntity;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class DoctorSpecifications {

    public static Specification<DoctorEntity> search(String search) {
        return (root, query, criteriaBuilder) -> {

            if (search == null || search.isBlank()) {
                return criteriaBuilder.conjunction();
            }

            String pattern = "%" + search.trim().toLowerCase() + "%";

            Join<DoctorEntity, UserEntity> userJoin = root.join("user");

            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(userJoin.get("username")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(userJoin.get("email")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("licenseNumber")),
                            pattern
                    )
            );
        };
    }

}
