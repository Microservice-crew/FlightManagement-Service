package com.example.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId; // Reference to the user making the booking
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight; // Reference to the booked flight
    private String seatNumber; // The selected seat number
    private Date bookingTime; // Date and time of the booking
    private String passengerName; // The name of the passenger
    private String passengerEmail; // The email of the passenger
    private String passengerPhone; // The phone number of the passenger
    private String paymentMethod; // The payment method used

    private double totalPrice;


}

