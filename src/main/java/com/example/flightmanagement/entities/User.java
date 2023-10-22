package com.example.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {


    private String _id;


    private String fullName;


    private String password;


    private String role;


    private String email;


    private String gender;


    private Boolean isActive;


    private Boolean isConfirmed;


    private String picture;


    private String coverPhoto;


    private String numTel;

    private String city;




    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", isActive=" + isActive +
                ", isConfirmed=" + isConfirmed +
                ", picture='" + picture + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", numTel='" + numTel + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
