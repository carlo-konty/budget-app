package org.ba.budgetapp2.businesslogic.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.repository.MovimentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MovimentiService {

    @Autowired
    private MovimentiRepository movimentiRepository;

    @Autowired
    private XLSService xlsService;

    public List<MovimentiModel> getAll() {
        return this.movimentiRepository.findAll();
    }

    public MovimentiModel save(MovimentiModel movimentiModel) {
        this.movimentiRepository.addMovimento(movimentiModel.getCategory(),movimentiModel.getDate(),movimentiModel.getDescription(),movimentiModel.getValue());
        return movimentiModel;
    }

    @Transactional
    public boolean saveAll() {
        Map<String,List<MovimentiModel>> data;
        try {
            data = this.xlsService.iterateOverFolder();
            for(Map.Entry<String, List<MovimentiModel>> entry : data.entrySet()) {
                for(MovimentiModel movimentiModel : entry.getValue()) {
                    save(movimentiModel);
                }
            }
        } catch (IOException exception) {
            log.error("Error: {}", exception.getMessage());
            return false;
        }
        return true;
    }



}
