package org.ba.budgetapp2.businesslogic.repository;

import jakarta.transaction.Transactional;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface MovimentiRepository extends JpaRepository<MovimentiModel,Long> {

    @Query(value = "SELECT * FROM BUDGET_DBA.MOVIMENTO",nativeQuery = true)
    List<MovimentiModel> findAll();

    @Transactional
    @Modifying
    @Query(value = "insert into budget_dba.movimento (category,date,description,value,conto_o_carta,id) " +
            "values (:category,:date,:description,:value,:conto_o_carta,nextval('movimento_seq'))",nativeQuery = true)
    void addMovimento(@Param(value = "category") String category,
                                @Param(value = "date") Date date,
                                @Param(value = "description") String description,
                                @Param(value = "value") Double value,
                                @Param(value = "conto_o_carta") String contoOrCarta
    );

    @Query(value = "select * from budget_dba.movimento \n" +
            "where (:m is null or date_part('month',date) = :m)\n" +
            "and (:y is null or date_part('year',date) = :y)",nativeQuery = true)
    List<MovimentiModel> getMovimentiModelByMonthAndYear(@Param("y") Integer year, @Param("m") Integer month);
}
