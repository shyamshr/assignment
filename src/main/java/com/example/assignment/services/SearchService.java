package com.example.assignment.services;

import com.example.assignment.models.Finances;
import com.example.assignment.repositories.FinancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private FinancesRepository financesRepository;
    @Autowired
    public SearchService(FinancesRepository financesRepository) {
        this.financesRepository = financesRepository;
    }
    public List<Finances> getTicker(String ticker) {
       return financesRepository.findByTicker(ticker);
    }
    public List<Finances> getTickerWithRevenueAndGPColumnsWithinPeriod(String ticker, String period) {
        return financesRepository.getTicker(ticker,period);
    }

}
