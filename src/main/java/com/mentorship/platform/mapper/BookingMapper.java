package com.mentorship.platform.mapper;

import com.mentorship.platform.dto.BookingRequest;
import com.mentorship.platform.dto.BookingResponse;
import com.mentorship.platform.model.Booking;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toEntity(BookingRequest request);
    BookingResponse toDTO(Booking booking);
}
