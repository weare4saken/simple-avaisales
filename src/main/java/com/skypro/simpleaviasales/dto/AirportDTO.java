package com.skypro.simpleaviasales.dto;

import com.skypro.simpleaviasales.model.Airport;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirportDTO {

    private Long id;
    private String name;
    private String city;
    private String address;


    public static AirportDTO from(Airport airport) {
        AirportDTO dto = new AirportDTO();
        dto.setId(airport.getId());
        dto.setName(airport.getName());
        dto.setCity(airport.getCity());
        dto.setAddress(airport.getAddress());
        return dto;
    }

}
