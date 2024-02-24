package com.example.assignment.dtos;

import com.example.assignment.models.Finances;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinanceDto {
    private int id;
    private String ticker;
    private String date;
    private Double revenue;
    private Double gp;

    private Double fcf;
    private Double capex;
    public static FinanceDto from(Finances finances) {
        FinanceDto financeDto = new FinanceDto();
        financeDto.setId(finances.getId());
        financeDto.setTicker(finances.getTicker());
        financeDto.setDate(finances.getDate());
        financeDto.setRevenue(finances.getRevenue());
        financeDto.setGp(finances.getGp());
        financeDto.setFcf(finances.getFcf());
        financeDto.setCapex(finances.getCapex());
        return financeDto;
    }
}
