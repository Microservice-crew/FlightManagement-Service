package com.example.flightmanagement.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight implements Serializable {
    private static final long serialVersionUID = 6711457437559348053L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private Date departureDateTime;  // Use Date or a suitable data type for date and time
    private Date arrivalDateTime;
    private String airline;
    private int availableSeats;
    private double ticketPrice;

}
