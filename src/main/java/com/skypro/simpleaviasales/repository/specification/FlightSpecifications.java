package com.skypro.simpleaviasales.repository.specification;

import com.skypro.simpleaviasales.model.Airline;
import com.skypro.simpleaviasales.model.Airport;
import com.skypro.simpleaviasales.model.Flight;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
public class FlightSpecifications {
public static Specification<Flight> byAirlineName(String airlineName){
    return ( root, query, criteriaBuilder ) -> {
        if(airlineName == null || airlineName.isBlank()) {
           return criteriaBuilder.conjunction();
        } else {
            Join<Flight, Airline> airlineJoin = root.join("airline");
            return criteriaBuilder.equal(airlineJoin.get("name"), airlineName);
        }
    };
}
public static Specification<Flight> byCityName(String cityName){
    return ( root, query, criteriaBuilder ) -> {
        if(cityName == null || cityName.isBlank()){
          return   criteriaBuilder.conjunction();
        } else {
            Join<Flight, Airport> departure = root.join("departureAirport");
            Join<Flight, Airport> arrival = root.join("arrivalAirport");
            Predicate depPred = criteriaBuilder.equal(departure.get("city"), cityName);
            Predicate arrPred = criteriaBuilder.equal(arrival.get("city"), cityName);
            return criteriaBuilder.or(depPred, arrPred);
        }
    };
}
public static Specification<Flight> byAirportName(String airportName){
    return ( root, query, criteriaBuilder ) -> {
        if(airportName == null || airportName.isBlank()){
          return   criteriaBuilder.conjunction();
        } else {
            Join<Flight, Airport> departure = root.join("departureAirport");
            Join<Flight, Airport> arrival = root.join("arrivalAirport");
            Predicate predDeparture = criteriaBuilder.equal(departure.get("name"), airportName);
            Predicate predArrival = criteriaBuilder.equal(arrival.get("name"), airportName);
            return criteriaBuilder.or(predDeparture, predArrival);
        }
    };
}
public static Specification<Flight> byDepartureDate( LocalDate departureDate ){
    return ( root, query, criteriaBuilder ) -> {
        if(departureDate == null ){
           return criteriaBuilder.conjunction();
        } else {
            Pair<Instant, Instant> rangeOfDay = between(departureDate);
            return criteriaBuilder.between(root.get("departureDate"), rangeOfDay.getFirst(), rangeOfDay.getSecond());
        }
    };

}
public static Specification<Flight> byArrivalDate(LocalDate arrivalDate){
    return ( root, query, criteriaBuilder ) -> {
        if(arrivalDate == null){
            return  criteriaBuilder.conjunction();
        } else {
            Pair<Instant, Instant> rangeOfDay = between(arrivalDate);
            return criteriaBuilder.between(root.get("arrivalDate"), rangeOfDay.getFirst(), rangeOfDay.getSecond());
        }
    };
}
private static Pair<Instant, Instant> between(LocalDate localDate){
    Instant start = localDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
    Instant end = localDate.atTime(23,59,59).atZone(ZoneId.of("UTC")).toInstant();
    return Pair.of(start, end);
}
}
