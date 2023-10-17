package com.example.flightmanagement.controller;

import com.example.flightmanagement.entities.Booking;
import com.example.flightmanagement.services.BookingService;
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


    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.CREATED);
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