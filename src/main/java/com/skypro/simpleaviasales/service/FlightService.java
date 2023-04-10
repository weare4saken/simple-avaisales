package com.skypro.simpleaviasales.service;

import com.skypro.simpleaviasales.dto.FilterDTO;
import com.skypro.simpleaviasales.dto.FlightDTO;
import com.skypro.simpleaviasales.exception.FlightNotFoundException;
import com.skypro.simpleaviasales.model.Flight;
import com.skypro.simpleaviasales.repository.FlightRepository;
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
public List<FlightDTO> findFlightsFiltered( FilterDTO dto ){
        List<Flight> flights = flightRepository.findAll(byAirlineName(dto.getAirlineName())
                .and(byCityName(dto.getCityName()))
                .and(byAirportName(dto.getAirportName()))
                .and(byDepartureDate(dto.getDepartureDate()))
                .and(byArrivalDate(dto.getArrivalDate())));
        return flights.stream().map(FlightDTO::from).collect(Collectors.toList());
}
public FlightDTO findFlightById(String flightNumber){
        Flight founded = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new FlightNotFoundException("Ни одного рейса не найдено!"));
        return FlightDTO.from(founded);
}
}
