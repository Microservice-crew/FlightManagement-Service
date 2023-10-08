package com.example.flightmanagement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Flight implements Serializable {
    private static final long serialVersionUID = 6711457437559348053L;

    @Id
    @GeneratedValue
    private Long id;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private Date departureDate;
    private Date arrivalDate;

}
