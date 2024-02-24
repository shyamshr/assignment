package com.example.assignment.controllers;

import com.example.assignment.dtos.FinanceDto;
import com.example.assignment.dtos.FinanceLiteDto;
import com.example.assignment.models.Finances;
import com.example.assignment.services.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @GetMapping("/ticker={ticker}")
    public ResponseEntity<List<FinanceDto>> getTicker(@PathVariable String ticker) {
        List<FinanceDto> financeDtos = new ArrayList<>();
        List<Finances> finances = searchService.getTicker(ticker);
        for(Finances finance : finances) {
            financeDtos.add(FinanceDto.from(finance));
        }
        return new ResponseEntity<List<FinanceDto>>(financeDtos, HttpStatus.OK);
    }
    @GetMapping("/ticker={ticker}/column={column}")
    public ResponseEntity<List<FinanceLiteDto>> getTickerWithRevenueAndGPColumns(@PathVariable @Value("ticker") String ticker) {
        List<FinanceLiteDto> financeLiteDtos = new ArrayList<>();
        List<Finances> finances = searchService.getTicker(ticker);
        for(Finances finance : finances) {
            financeLiteDtos.add(FinanceLiteDto.from(finance));
        }
        return new ResponseEntity<List<FinanceLiteDto>>(financeLiteDtos, HttpStatus.OK);
    }
    @GetMapping("/ticker={ticker}/column={column}/period={period}")
    public ResponseEntity<List<FinanceLiteDto>> getTickerWithRevenueAndGPColumnsWithinPeriod(@PathVariable @Value("ticker") String ticker,@PathVariable @Value("period") String period) {
        List<FinanceLiteDto> financeLiteDtos = new ArrayList<>();
        List<Finances> finances = searchService.getTickerWithRevenueAndGPColumnsWithinPeriod(ticker, period.substring(0,period.length()-1));//5y 6y
        for(Finances finance : finances) {
            financeLiteDtos.add(FinanceLiteDto.from(finance));
        }
        return new ResponseEntity<>(financeLiteDtos, HttpStatus.OK);
    }


}
