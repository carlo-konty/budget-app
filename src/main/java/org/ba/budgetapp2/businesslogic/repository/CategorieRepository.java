package org.ba.budgetapp2.businesslogic.repository;

import org.ba.budgetapp2.businesslogic.entities.CategorieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieModel, Long> {

    @Query(value = "SELECT * FROM BUDGET_DBA.CATEGORIA",nativeQuery = true)
    List<CategorieModel> getAll();
}
