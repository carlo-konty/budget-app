package org.ba.budgetapp2.businesslogic.repository;

import jakarta.transaction.Transactional;
import org.ba.budgetapp2.businesslogic.entities.CategorieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieModel, Long> {

    @Query(value = "SELECT * FROM BUDGET_DBA.CATEGORIA",nativeQuery = true)
    List<CategorieModel> getAll();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO BUDGET_DBA.CATEGORIA (id, name, value, update_date) " +
            "VALUES (nextval('categoria_seq'),:name,:value,:date)",nativeQuery = true)
    void save(@Param("name") String name, @Param("value") Integer value, @Param("date") Date updateDate);
}
