package com.example.hotelproject.controller;

import java.util.List;

import com.example.hotelproject.entity.Equipment;
import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.repository.EquipmentRepository;
import com.example.hotelproject.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotel_id}/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public String index(@PathVariable Long hotel_id, Model model) {
        List<Equipment> equipments = equipmentRepository.findByHotelId(hotel_id);
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("equipments", equipments);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Equipment Index");
        return "equipment/index";
    }
}