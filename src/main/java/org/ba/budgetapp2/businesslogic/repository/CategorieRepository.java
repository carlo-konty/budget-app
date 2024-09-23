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

    @Query(value = "SELECT * FROM BUDGET_DBA.CATEGORIA ORDER BY name ASC",nativeQuery = true)
    List<CategorieModel> getAll();

    @Query(value = "SELECT * FROM BUDGET_DBA.CATEGORIA WHERE type = :type ORDER BY NAME ASC",nativeQuery = true)
    List<CategorieModel> getByType(@Param("type") String type);

    @Query(value = "SELECT * FROM BUDGET_DBA.CATEGORIA \n" +
            "WHERE (:type IS NULL OR type LIKE  '%' || :type || '%') \n" +
            "AND (:name IS NULL OR UPPER(name) LIKE UPPER(:name) || '%') \n" +
            "ORDER BY value asc",nativeQuery = true)
    List<CategorieModel> getByTypeAndName(@Param("type") String type, @Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO BUDGET_DBA.CATEGORIA (id, name, value, update_date, type) " +
            "VALUES (nextval('categoria_seq'),:name,:value,:date,:type)",nativeQuery = true)
    void save(@Param("name") String name, @Param("value") Integer value, @Param("date") Date updateDate, @Param("type") String type);
}
