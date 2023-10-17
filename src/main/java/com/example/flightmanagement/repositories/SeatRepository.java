package com.example.flightmanagement.repositories;

import com.example.flightmanagement.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
