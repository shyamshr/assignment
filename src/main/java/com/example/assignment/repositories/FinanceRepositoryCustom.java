package com.example.assignment.repositories;

import java.util.List;

public interface FinanceRepositoryCustom {
    List<Object> getTicker(String ticker, String column, String period);
}
