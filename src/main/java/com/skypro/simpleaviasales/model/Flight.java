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
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport arrivalAirport;
    @ManyToOne
    private Airline airline;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

}
