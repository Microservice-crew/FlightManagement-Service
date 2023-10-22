package com.example.flightmanagement.controller;

import com.example.flightmanagement.entities.Booking;
import com.example.flightmanagement.entities.Seat;
import com.example.flightmanagement.entities.User;
import com.example.flightmanagement.feign.userService;
import com.example.flightmanagement.services.BookingService;
import com.example.flightmanagement.services.FlightService;
import com.example.flightmanagement.entities.Flight;
import com.example.flightmanagement.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/flights")
@CrossOrigin(origins = "*")
public class FlightController {
    @Autowired
    private FlightService flightServices;
    @Autowired
    private BookingService bookingService;

    @Autowired
    private userService userService;

    @Autowired
    private SeatService seatService;

    @GetMapping(value="/flight/all")
    public List<Flight> getAllFlights(){
        return flightServices.getAllFlights();
    }

    //getbyid

    @GetMapping(value="/flight/{id}")
    public Flight getFlightById(@PathVariable Integer id){
        return flightServices.getFlightById(id);
    }
    //add
    @PostMapping(value="/flight/add")
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
        return new ResponseEntity<Flight>(flightServices.saveFlight(flight), HttpStatus.CREATED);
    }
    //update
    @PutMapping (value="/flight/update/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id,@RequestBody  Flight flight){
        return new ResponseEntity<Flight>(flightServices.updateFlight(id,flight), HttpStatus.OK);
    }
    //delete
    @DeleteMapping( value="/flight/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Integer id){
        flightServices.deleteFlight(id);
        return new ResponseEntity<String>("Flight deleted", HttpStatus.OK);
    }

    @GetMapping("/booking/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking/{id}")
    public Booking getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/booking/add/{userId}/{flightId}")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking, @PathVariable String userId, @PathVariable Integer flightId) {

        User user = userService.getUserById(userId);
        Flight flight = flightServices.getFlightById(flightId);
        booking.setUserId(user.get_id());
        booking.setFlightId(flight.getId());
        //console log
        System.out.println("user id is "+user.get_id());

        Booking createdBooking = bookingService.createBooking(booking, userId, flightId);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }


    @PutMapping("/booking/update/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Integer id, @RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.updateBooking(id, booking), HttpStatus.OK);
    }

    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<String>("Booking deleted", HttpStatus.OK);
    }





    @GetMapping("/seat/all")
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/seat/{id}")
    public Seat getSeatById(@PathVariable Integer id) {
        return seatService.getSeatById(id);
    }

    @PostMapping("/seat/add")
    public ResponseEntity<Seat> saveSeat(@RequestBody Seat seat) {
        return new ResponseEntity<Seat>(seatService.saveSeat(seat), HttpStatus.CREATED);
    }

    @PutMapping("/seat/update/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Integer id, @RequestBody Seat seat) {
        return new ResponseEntity<Seat>(seatService.updateSeat(id, seat), HttpStatus.OK);
    }

    @DeleteMapping("/seat/delete/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeat(id);
        return new ResponseEntity<String>("Seat deleted", HttpStatus.OK);
    }

}
