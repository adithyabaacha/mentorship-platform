package com.mentorship.platform.repository;

import com.mentorship.platform.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
