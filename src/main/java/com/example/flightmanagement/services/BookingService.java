package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking getBookingById(Integer id);

    Booking createBooking(Booking booking);

    Booking updateBooking(Integer id, Booking booking);

    void deleteBooking(Integer id);
}

