package com.example.flightmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServicesImp implements FlightService{


    @Override
    public List<Flight> getAllFlights() {
        return null;
    }

    @Override
    public Flight getFlightById(Long id) {
        return null;
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return null;
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return null;
    }

    @Override
    public void deleteFlight(Long id) {

    }
}
