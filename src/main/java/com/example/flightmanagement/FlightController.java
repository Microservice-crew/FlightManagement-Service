package com.example.flightmanagement;

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
    public Flight getFlightById(Long id){
        return flightServices.getFlightById(id);
    }
    //add
    @PostMapping(value="/add")
    public ResponseEntity<Flight> saveFlight(Flight flight){
        return new ResponseEntity<Flight>(flightServices.saveFlight(flight), HttpStatus.CREATED);
    }
    //update
    @PutMapping (value="/update")
    public ResponseEntity<Flight> updateFlight(Flight flight){
        return new ResponseEntity<Flight>(flightServices.updateFlight(flight), HttpStatus.OK);
    }
    //delete
    @DeleteMapping( value="/delete")
    public ResponseEntity<String> deleteFlight(Long id){
        flightServices.deleteFlight(id);
        return new ResponseEntity<String>("Flight deleted", HttpStatus.OK);
    }

}
