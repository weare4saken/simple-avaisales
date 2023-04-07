package com.skypro.simpleaviasales.repository.specification;

import com.skypro.simpleaviasales.model.Airline;
import com.skypro.simpleaviasales.model.Flight;
import com.sun.xml.bind.v2.TODO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class FlightSpecifications {
    public static Specification<Flight> byAirline(String airlineName){
        return (root, query, criteriaBuilder) -> {
            if (airlineName == null || airlineName.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            Join<Flight, Airline> airline = root.join("airline");
            return criteriaBuilder.equal(airline.get("name"), airlineName);
        };
    }


//TODO:ДОДЕЛАТЬ
    public static Specification<Flight> byAirportName(String airportName){
        return (root, query, criteriaBuilder) -> {
            Join<Flight, Airline> airline = root.join("airline");
            return criteriaBuilder.equal(airline.get("name"), airportName);
        };
    }




}
