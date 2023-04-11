package com.skypro.simpleaviasales.service;

import com.skypro.simpleaviasales.dto.FilterDTO;
import com.skypro.simpleaviasales.dto.FlightDTO;
import com.skypro.simpleaviasales.exception.FlightNotFoundException;
import com.skypro.simpleaviasales.model.Flight;
import com.skypro.simpleaviasales.repository.FlightRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.skypro.simpleaviasales.repository.specification.FlightSpecifications.*;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getFlightsFiltered(FilterDTO filterDTO) {
        List<Flight> flights = flightRepository.findAll(Specification.where(
                byAirline(filterDTO.getAirlineName())
                .and(byAirportName(filterDTO.getAirportName()))
                .and(byCityName(filterDTO.getCityName()))
                .and(byDepartureDate(filterDTO.getDepartureDate()))
                .and(byArrivalDate(filterDTO.getArrivalDate()))));
        return flights.stream().map(FlightDTO::from).collect(Collectors.toList());
    }

    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber).orElseThrow(FlightNotFoundException::new);
    }

}
