package com.example.flightmanagement.controller;

import com.example.flightmanagement.services.FlightService;
import com.example.flightmanagement.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/flights")
public class FlightController {
    @Autowired
    private FlightService flightServices;

    @GetMapping(value="/all")
    public List<Flight> getAllFlights(){
        return flightServices.getAllFlights();
    }

    //getbyid

    @GetMapping(value="/{id}")
    public Flight getFlightById(@PathVariable Integer id){
        return flightServices.getFlightById(id);
    }
    //add
    @PostMapping(value="/add")
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
        return new ResponseEntity<Flight>(flightServices.saveFlight(flight), HttpStatus.CREATED);
    }
    //update
    @PutMapping (value="/update/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id,@RequestBody  Flight flight){
        return new ResponseEntity<Flight>(flightServices.updateFlight(id,flight), HttpStatus.OK);
    }
    //delete
    @DeleteMapping( value="/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Integer id){
        flightServices.deleteFlight(id);
        return new ResponseEntity<String>("Flight deleted", HttpStatus.OK);
    }

}
