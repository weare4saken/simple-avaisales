package com.skypro.simpleaviasales.controller;

import com.skypro.simpleaviasales.dto.FilterDTO;
import com.skypro.simpleaviasales.dto.FlightDTO;
import com.skypro.simpleaviasales.model.Flight;
import com.skypro.simpleaviasales.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<FlightDTO> getFlights(FilterDTO filterDTO) {
        return null;
//                flightService.(filterDTO);
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }


}
