package com.skypro.simpleaviasales.service;

import com.skypro.simpleaviasales.dto.FlightDTO;
import com.skypro.simpleaviasales.model.Flight;
import com.skypro.simpleaviasales.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getFlightsFiltered(String airlineName,
                                              String airportName,
                                              String cityName,
                                              LocalDate departureDate,
                                              LocalDate arrivalDate) {
        List<Flight> flights = flightRepository.findFilteredFlights(airlineName, airportName, cityName, departureDate, arrivalDate);

        return flights.stream().map(FlightDTO::from).collect(Collectors.toList());
    }


    public Flight getFlightById(Long id) {
        return null;
    }
}
