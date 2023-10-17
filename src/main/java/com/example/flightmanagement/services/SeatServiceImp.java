package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Seat;
import com.example.flightmanagement.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImp implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(Integer id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Integer id, Seat seat) {
     //updateSeat
        Seat existingSeat=seatRepository.findById(id).orElse(null);
        existingSeat.setSeatNumber(seat.getSeatNumber());

        existingSeat.setSeatClass(seat.getSeatClass());

        existingSeat.setAvailable(seat.isAvailable());
        return seatRepository.save(existingSeat);
    }

    public void deleteSeat(Integer id) {
        seatRepository.deleteById(id);
    }
}