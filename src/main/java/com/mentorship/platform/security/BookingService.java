package com.mentorship.platform.service;

import com.mentorship.platform.dto.BookingRequest;
import com.mentorship.platform.dto.BookingResponse;
import com.mentorship.platform.mapper.BookingMapper;
import com.mentorship.platform.model.*;
import com.mentorship.platform.repository.AvailabilityRepository;
import com.mentorship.platform.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final AvailabilityRepository availabilityRepository;
    private final BookingMapper bookingMapper;

    public BookingResponse createBooking(BookingRequest request) {
        Booking booking = bookingMapper.toEntity(request);
        booking.setStatus(BookingStatus.PENDING);
        Booking saved = bookingRepository.save(booking);
        return bookingMapper.toDTO(saved);
    }

    public void confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        availabilityRepository.findAll().stream()
                .filter(a -> a.getMentorId().equals(booking.getMentorId()) &&
                        a.getStartTime().equals(booking.getStartTime()) &&
                        !a.isBooked())
                .findFirst()
                .ifPresent(a -> {
                    a.setBooked(true);
                    availabilityRepository.save(a);
                });
    }
}
