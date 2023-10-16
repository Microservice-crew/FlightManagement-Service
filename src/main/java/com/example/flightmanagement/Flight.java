package com.example.flightmanagement;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private String departureDate;
    private String arrivalDate;
    private String departureTime;
    private String arrivalTime;

}
