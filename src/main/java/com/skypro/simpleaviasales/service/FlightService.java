package com.skypro.simpleaviasales.service;

import com.skypro.simpleaviasales.dto.FilterDTO;
import com.skypro.simpleaviasales.dto.FlightDTO;
import com.skypro.simpleaviasales.model.Flight;
import com.skypro.simpleaviasales.repository.FlightRepository;
import com.skypro.simpleaviasales.repository.specification.FlightSpecifications;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.skypro.simpleaviasales.repository.specification.FlightSpecifications.byAirline;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getFlightsFiltered(FilterDTO filterDTO) {
        List<Flight> flights = flightRepository.findAll(byAirline(filterDTO.getAirlineName()));
        return flights.stream().map(FlightDTO::from).collect(Collectors.toList());
    }


    public Flight getFlightById(Long id) {
        return null;
    }
}
