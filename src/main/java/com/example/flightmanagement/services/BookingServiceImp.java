package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Booking;
import com.example.flightmanagement.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Integer id, Booking booking) {
     //update booking
        Booking existingBooking=bookingRepository.findById(id).orElse(null);
        existingBooking.setUserId(booking.getUserId());
        existingBooking.setFlight(booking.getFlight());
        existingBooking.setSeatNumber(booking.getSeatNumber());
        existingBooking.setBookingTime(booking.getBookingTime());
        existingBooking.setPassengerName(booking.getPassengerName());
        existingBooking.setPassengerEmail(booking.getPassengerEmail());
        existingBooking.setPassengerPhone(booking.getPassengerPhone());
        existingBooking.setPaymentMethod(booking.getPaymentMethod());
        existingBooking.setTotalPrice(booking.getTotalPrice());





        return bookingRepository.save(existingBooking);

    }

    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }
}