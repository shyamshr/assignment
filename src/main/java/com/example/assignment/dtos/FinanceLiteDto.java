package com.example.assignment.dtos;

import com.example.assignment.models.Finances;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinanceLiteDto {
    private String ticker;
    private String date;
    private Double revenue;
    private Double gp;
    public static FinanceLiteDto from(Finances finances) {
        FinanceLiteDto financeLiteDto = new FinanceLiteDto();
        financeLiteDto.setTicker(finances.getTicker());
        financeLiteDto.setDate(finances.getDate());
        financeLiteDto.setRevenue(finances.getRevenue());
        financeLiteDto.setGp(finances.getGp());
        return financeLiteDto;
    }
}
