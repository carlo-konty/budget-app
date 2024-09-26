package org.ba.budgetapp2.businesslogic.service;

import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.CategorieModel;
import org.ba.budgetapp2.businesslogic.repository.CategorieRepository;
import org.ba.budgetapp2.costants.Category;
import org.ba.budgetapp2.costants.MappaIntesaFoglio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<CategorieModel> getAll() {
        return this.categorieRepository.getAll();
    }

    public List<CategorieModel> getByType(String type) {
        return this.categorieRepository.getByType(type);
    }

    public List<CategorieModel> getByTypeAndName(String type, String name) {
        return this.categorieRepository.getByTypeAndName(type,name);
    }

    public void save(CategorieModel categorieModel) {
        this.categorieRepository.save(categorieModel.getName(),categorieModel.getValue(),new Date(),categorieModel.getType());
    }

    public boolean saveAll() {
        try {
            Map<String,Integer> intesaMap = MappaIntesaFoglio.getMapIntesa();
            Map<String,Integer> categoriaMap = Category.getMap();
            for(Map.Entry<String,Integer> entry : intesaMap.entrySet()) {
                this.categorieRepository.save(entry.getKey(),entry.getValue(),new Date(),"INTESA");
            }
            for(Map.Entry<String,Integer> entry : categoriaMap.entrySet()) {
                this.categorieRepository.save(entry.getKey(),entry.getValue(),new Date(),"FOGLIO");
            }
        } catch (Exception e) {
            log.error("error: {}",e.getMessage());
            return false;
        }
        return true;
    }

    public CategorieModel update(CategorieModel categorieModel) {
        categorieModel.setUpdateDate(new Date());
        this.categorieRepository.update(
                categorieModel.getName(),
                categorieModel.getValue(),
                categorieModel.getUpdateDate(),
                categorieModel.getType(),
                categorieModel.getId()
        );
        return categorieModel;
    }

    public CategorieModel delete(CategorieModel categorieModel) {
        this.categorieRepository.delete(categorieModel.getId());
        return categorieModel;
    }
}
