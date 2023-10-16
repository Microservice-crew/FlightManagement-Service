package com.example.flightmanagement;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    Flight getFlightById(Long id);
    Flight saveFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Long id);

}
