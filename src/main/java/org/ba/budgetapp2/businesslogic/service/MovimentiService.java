package org.ba.budgetapp2.businesslogic.service;

import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.repository.MovimentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentiService {

    @Autowired
    private MovimentiRepository movimentiRepository;

    public List<MovimentiModel> getAll() {
        return this.movimentiRepository.findAll();
    }

    public MovimentiModel save(MovimentiModel movimentiModel) {
        this.movimentiRepository.addMovimento(movimentiModel.getCategory(),movimentiModel.getDate(),movimentiModel.getDescription(),movimentiModel.getValue());
        return movimentiModel;
    }

}
