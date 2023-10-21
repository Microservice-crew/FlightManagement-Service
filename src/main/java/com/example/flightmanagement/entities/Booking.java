package com.example.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //manytoOne user

    private  String userId;


    private Integer flightId; // The id of the flight
    private String seatNumber; // The selected seat number
    private Date bookingTime; // Date and time of the booking
    private String passengerName; // The name of the passenger
    private String passengerEmail; // The email of the passenger
    private String passengerPhone; // The phone number of the passenger
    private String paymentMethod; // The payment method used

    private double totalPrice;


}

