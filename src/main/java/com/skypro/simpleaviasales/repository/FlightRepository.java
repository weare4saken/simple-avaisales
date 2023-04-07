package com.skypro.simpleaviasales.repository;

import com.skypro.simpleaviasales.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findFilteredFlights(String airlineName, String airportName, String cityName, LocalDate departureDate, LocalDate arrivalDate);

}
