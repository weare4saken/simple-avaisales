package com.skypro.simpleaviasales.repository.specification;

import com.skypro.simpleaviasales.model.Airline;
import com.skypro.simpleaviasales.model.Airport;
import com.skypro.simpleaviasales.model.Flight;
import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


public class FlightSpecifications {

    public static Specification<Flight> byAirline(String airlineName) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(airlineName)) {
                return criteriaBuilder.conjunction();
            }
            Join<Flight, Airline> airline = root.join("airline");
            return criteriaBuilder.equal(airline.get("name"), airlineName);
        };
    }

    public static Specification<Flight> byAirportName(String airportName) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(airportName)) {
                return criteriaBuilder.conjunction();
            }
            Join<Flight, Airport> airportDeparture = root.join("departureAirport");
            Join<Flight, Airport> airportArrival = root.join("arrivalAirport");
            Predicate predicateDeparture = criteriaBuilder.equal(airportDeparture.get("name"), airportName);
            Predicate predicateArrival = criteriaBuilder.equal(airportArrival.get("name"), airportName);
            return criteriaBuilder.or(predicateDeparture, predicateArrival);
        };
    }

    public static Specification<Flight> byCityName(String cityName) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(cityName)) {
                return criteriaBuilder.conjunction();
            }
            Join<Flight, Airport> airportDeparture = root.join("departureAirport");
            Join<Flight, Airport> airportArrival = root.join("arrivalAirport");
            Predicate predicateDeparture = criteriaBuilder.equal(airportDeparture.get("city"), cityName);
            Predicate predicateArrival = criteriaBuilder.equal(airportArrival.get("city"), cityName);
            return criteriaBuilder.or(predicateDeparture, predicateArrival);
        };
    }

    public static Specification<Flight> byDepartureDate(LocalDate departureDate) {
        return (root, query, criteriaBuilder) -> {
            if (departureDate == null) {
                return criteriaBuilder.conjunction();
            }
            Pair<Instant, Instant> dateRange = toDateRange(departureDate);
            return criteriaBuilder.between(root.get("departureDate"), dateRange.getLeft(), dateRange.getRight());
        };
    }

    public static Specification<Flight> byArrivalDate(LocalDate arrivalDate) {
        return (root, query, criteriaBuilder) -> {
            if (arrivalDate == null) {
                return criteriaBuilder.conjunction();
            }
            Pair<Instant, Instant> dateRange = toDateRange(arrivalDate);
            return criteriaBuilder.between(root.get("arrivalDate"), dateRange.getLeft(), dateRange.getRight());
        };
    }

    private static Pair<Instant, Instant> toDateRange(LocalDate localDate) {
        Instant startOfDay = localDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
        Instant endOfDay = localDate.atTime(23,59,59).atZone(ZoneId.of("UTC")).toInstant();
        return Pair.of(startOfDay,endOfDay);
    }

}
