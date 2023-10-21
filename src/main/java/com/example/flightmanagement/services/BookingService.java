package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Booking;
import com.example.flightmanagement.entities.User;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    User getUserDetails(String userId) ;

    Booking getBookingById(Integer id);

    Booking createBooking(Booking booking, String userId, Integer flightId);

    Booking updateBooking(Integer id, Booking booking);

    void deleteBooking(Integer id);
}

