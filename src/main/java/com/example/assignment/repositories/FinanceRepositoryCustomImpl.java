package com.example.assignment.repositories;

import com.example.assignment.models.Finances;
import com.example.assignment.models.QFinances;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FinanceRepositoryCustomImpl implements FinanceRepositoryCustom {
       @PersistenceContext
       private EntityManager entityManager;
       public static QFinances qFinances = QFinances.finances;

        @Override
        public List<Object> getTicker(String ticker, String column, String period) {
            JPAQuery<Finances> jpaQuery = new JPAQuery<>(entityManager);
            Map<String, Expression<?>> colDef = new HashMap<>();
            colDef.put("id", qFinances.id);
            colDef.put("ticker", qFinances.ticker);
            colDef.put("date", qFinances.date);
            colDef.put("revenue", qFinances.revenue);
            colDef.put("gp", qFinances.gp);
            colDef.put("fcf", qFinances.fcf);
            colDef.put("capex", qFinances.capex);

            String[] cols = column.split(",");
            Map<String, Expression<?>> columns = new HashMap<>();
            for(String col: cols) {
                columns.put(col, colDef.get(col));
            }



            QBean<Finances> financesQBean = Projections.bean(Finances.class,
                   columns);

            List<Object> result = Collections.singletonList(jpaQuery
                    .from(qFinances)
                    .where(qFinances.ticker.eq(ticker))
                    .select(financesQBean)
                    .fetch());

            //return
            return result;
        }
    }



