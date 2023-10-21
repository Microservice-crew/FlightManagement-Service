package com.example.flightmanagement.controller;

import com.example.flightmanagement.entities.Booking;
import com.example.flightmanagement.entities.Flight;
import com.example.flightmanagement.entities.User;
import com.example.flightmanagement.services.BookingService;
import com.example.flightmanagement.services.FlightService;
import com.example.flightmanagement.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

@Autowired
private userService userService;
    @Autowired
    private FlightService flightService;
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/add/{userId}/{flightId}")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking, @PathVariable String userId, @PathVariable Integer flightId) {

        User user = userService.getUserById(userId);
        Flight flight = flightService.getFlightById(flightId);
        booking.setUserId(user.get_id());
        booking.setFlightId(flight.getId());
        //console log
        System.out.println("user id is "+user.get_id());

        Booking createdBooking = bookingService.createBooking(booking, userId, flightId);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Integer id, @RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.updateBooking(id, booking), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<String>("Booking deleted", HttpStatus.OK);
    }
}