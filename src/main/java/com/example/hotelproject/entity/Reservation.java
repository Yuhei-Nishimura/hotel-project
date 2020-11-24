package com.example.hotelproject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private Long numberOfPeople;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chechin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chechout;



    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Date getChechin() {
        return chechin;
    }

    public void setChechin(Date chechin) {
        this.chechin = chechin;
    }

    public Date getChechout() {
        return chechout;
    }

    public void setChechout(Date chechout) {
        this.chechout = chechout;
    }

}