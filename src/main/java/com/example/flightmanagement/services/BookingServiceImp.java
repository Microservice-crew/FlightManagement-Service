package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Booking;
import com.example.flightmanagement.entities.User;
import com.example.flightmanagement.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private com.example.flightmanagement.feign.userService userService;
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public User getUserDetails(String userId) {
        return userService.getUserById(userId);
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking, String userId, Integer flightId) {

        User user = userService.getUserById(userId);
        booking.setUserId(user.get_id());
        booking.setFlightId(flightId);
//console log
        System.out.println("user id is "+user.get_id());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Integer id, Booking booking) {
     //update booking
        Booking existingBooking=bookingRepository.findById(id).orElse(null);
        existingBooking.setUserId(booking.getUserId());
        existingBooking.setFlightId(booking.getFlightId());
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