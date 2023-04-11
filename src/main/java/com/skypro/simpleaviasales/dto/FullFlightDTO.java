package com.skypro.simpleaviasales.dto;

import com.skypro.simpleaviasales.model.Flight;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class FullFlightDTO {

    private String flightNumber;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;
    private AirlineDTO airline;
    private Instant departureDate;
    private Instant arrivalDate;


    public static FullFlightDTO from(Flight flight) {
        FullFlightDTO dto = new FullFlightDTO();
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setDepartureAirport(AirportDTO.from(flight.getDepartureAirport()));
        dto.setArrivalAirport(AirportDTO.from(flight.getArrivalAirport()));
        dto.setAirline(AirlineDTO.from(flight.getAirline()));
        dto.setDepartureDate(flight.getDepartureDate());
        dto.setArrivalDate(flight.getArrivalDate());
        return dto;
    }

}
