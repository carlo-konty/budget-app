package org.ba.budgetapp2.businesslogic.service;

import org.ba.budgetapp2.businesslogic.entities.CategorieModel;
import org.ba.budgetapp2.businesslogic.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<CategorieModel> getAll() {
        return this.categorieRepository.getAll();
    }
}
