package com.example.flightmanagement.services;

import com.example.flightmanagement.entities.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getAllSeats();

    Seat getSeatById(Integer id);

    Seat saveSeat(Seat seat);

    Seat updateSeat(Integer id, Seat seat);

    void deleteSeat(Integer id);
}
