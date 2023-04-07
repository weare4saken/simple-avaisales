package com.skypro.simpleaviasales.dto;

import com.skypro.simpleaviasales.model.Flight;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Data
public class FlightDTO {
    private String flightNumber;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String departureAirportName;
    private String arrivalAirportName;
    private String airlineName;

    public static FlightDTO from(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setDepartureDate(flight.getDepartureDate());
        dto.setArrivalDate(flight.getArrivalDate());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setDepartureAirportName(flight.getDepartureAirport().getName());
        dto.setArrivalAirportName(flight.getArrivalAirport().getName());
        dto.setAirlineName(flight.getAirline().getName());
        return dto;
    }

}
