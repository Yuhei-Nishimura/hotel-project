package com.example.hotelproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean parking;
    private boolean wifi;
    private boolean airportbus;
    private boolean hotspring;


    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isAirportbus() {
        return airportbus;
    }

    public void setAirportbus(boolean airportbus) {
        this.airportbus = airportbus;
    }

    public boolean isHotspring() {
        return hotspring;
    }

    public void setHotspring(boolean hotspring) {
        this.hotspring = hotspring;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}