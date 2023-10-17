package com.example.flightmanagement.controller;

import com.example.flightmanagement.entities.Seat;
import com.example.flightmanagement.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;


    @GetMapping("/all")
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Integer id) {
        return seatService.getSeatById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Seat> saveSeat(@RequestBody Seat seat) {
        return new ResponseEntity<Seat>(seatService.saveSeat(seat), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Integer id, @RequestBody Seat seat) {
        return new ResponseEntity<Seat>(seatService.updateSeat(id, seat), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeat(id);
        return new ResponseEntity<String>("Seat deleted", HttpStatus.OK);
    }
}