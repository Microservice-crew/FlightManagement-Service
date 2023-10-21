package com.example.flightmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String seatNumber;
    private String seatClass;
    private boolean isAvailable;

}
