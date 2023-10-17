package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    Flight getFlightById(Integer id);
    Flight saveFlight(Flight flight);
    Flight updateFlight(Integer id,Flight flight);
    void deleteFlight(Integer id);

}
