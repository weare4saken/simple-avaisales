package com.skypro.simpleaviasales.controller;

import com.skypro.simpleaviasales.dto.FilterDTO;
import com.skypro.simpleaviasales.dto.FlightDTO;
import com.skypro.simpleaviasales.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    @GetMapping
    public List<FlightDTO> getFlights( FilterDTO filterDTO ) {
        return flightService.findFlightsFiltered(filterDTO);
    }
    @GetMapping("/{flightNumber}")
    public FlightDTO getFlightById(@PathVariable String flightNumber){
        return flightService.findFlightById(flightNumber);
    }
}
