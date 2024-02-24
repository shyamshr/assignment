package com.example.assignment.repositories;

import com.example.assignment.models.Finances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancesRepository extends JpaRepository<Finances, Integer>{
    @Query(value = "select * from finances where ticker= :ticker ;", nativeQuery = true)
    List<Finances> findByTicker(@Param("ticker") String ticker);
    @Query(value = "select * from finances where ticker= :ticker and year(CURRENT_DATE())-year(str_to_date(date,'%m/%d/%Y'))< :period ;", nativeQuery = true)
    List<Finances> getTicker(@Param("ticker") String ticker, @Param("period") String period);


}
