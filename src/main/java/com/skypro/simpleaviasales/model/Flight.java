package com.skypro.simpleaviasales.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Flight {

    @Id
    private String flightNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Airport departureAirport;
    @ManyToOne(fetch = FetchType.LAZY)
    private Airport arrivalAirport;
    @ManyToOne(fetch = FetchType.LAZY)
    private Airline airline;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

}
