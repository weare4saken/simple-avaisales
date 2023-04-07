package com.skypro.simpleaviasales.dto;

import com.skypro.simpleaviasales.model.Flight;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZoneOffset;


@Data
public class FlightDTO {
    private String flightNumber;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String departureAirportName;
    private String arrivalAirportName;
    private String airlineName;

    public static FlightDTO from(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setDepartureDate(LocalDate.from(flight.getDepartureDate().toInstant(ZoneOffset.UTC)));
        dto.setArrivalDate(LocalDate.from(flight.getArrivalDate().toInstant(ZoneOffset.UTC)));
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setDepartureAirportName(flight.getDepartureAirport().getName());
        dto.setArrivalAirportName(flight.getArrivalAirport().getName());
        dto.setAirlineName(flight.getAirline().getName());
        return dto;
    }

}
