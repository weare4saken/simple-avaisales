package com.skypro.simpleaviasales.dto;

import com.skypro.simpleaviasales.model.Airline;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirlineDTO {

    private Long id;
    private String name;


    public static AirlineDTO from(Airline airline) {
        AirlineDTO dto = new AirlineDTO();
        dto.setId(airline.getId());
        dto.setName(airline.getName());
        return dto;
    }
}
