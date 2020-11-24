package com.example.hotelproject.controller;

import java.util.List;

import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.entity.Reservation;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotel_id}/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public String index(@PathVariable Long hotel_id, Model model) {
        List<Reservation> reservations = reservationRepository.findByHotelId(hotel_id);
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("reservations", reservations);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Reservation Index");
        return "reservation/index";
    }
    @GetMapping("new")
    public String newReservation(@PathVariable Long hotel_id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "New Reservation");
        return "reservation/new";
    }

    @PostMapping
    public String create(@PathVariable Long hotel_id, @ModelAttribute Reservation reservation) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        reservation.setHotel(hotel);
        reservationRepository.save(reservation);
        return "redirect:/hotels/{hotel_id}/reservations/" + reservation.getId();
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long hotel_id,@PathVariable Long id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        model.addAttribute("reservation", reservation);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Edit Reservation");
        return "reservation/edit";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long hotel_id,@PathVariable Long id, @ModelAttribute Reservation reservation) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        reservation.setHotel(hotel);
        reservation.setId(id);
        reservationRepository.save(reservation);
        return "redirect:/hotels/{hotel_id}/reservations";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long hotel_id,@PathVariable Long id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        model.addAttribute("reservation", reservation);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Show Reservation");
        return "reservation/show";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return "redirect:/hotels/{hotel_id}/reservations";
    }
}