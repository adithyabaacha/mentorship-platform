package com.mentorship.platform.repository;

import com.mentorship.platform.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByMentorIdAndIsBookedFalse(Long mentorId);
}
