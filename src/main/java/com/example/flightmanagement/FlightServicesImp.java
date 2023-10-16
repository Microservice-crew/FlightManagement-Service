package com.example.flightmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServicesImp implements FlightService{
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {


        return flightRepository.findAll();

    }

    @Override
    public Flight getFlightById(Integer id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public Flight saveFlight(Flight flight) {
      return flightRepository.save(flight);

    }

    @Override
    public Flight updateFlight(Integer id,Flight flight) {
//update flight
        Flight existingFlight=flightRepository.findById(id).orElse(null);
        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setDepartureCity(flight.getDepartureCity());
        existingFlight.setArrivalCity(flight.getArrivalCity());
        existingFlight.setDepartureDate(flight.getDepartureDate());
        existingFlight.setArrivalDate(flight.getArrivalDate());
        existingFlight.setDepartureTime(flight.getDepartureTime());
        existingFlight.setArrivalTime(flight.getArrivalTime());
        return flightRepository.save(existingFlight);
    }

    @Override
    public void deleteFlight(Integer id) {
        //Delete
        flightRepository.deleteById(id);

    }
}
