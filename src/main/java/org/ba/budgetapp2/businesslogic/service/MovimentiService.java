package org.ba.budgetapp2.businesslogic.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.repository.MovimentiRepository;
import org.ba.budgetapp2.businesslogic.service.intesa.IntesaXlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MovimentiService {

    @Autowired
    private MovimentiRepository movimentiRepository;

    public List<MovimentiModel> getAll() {
        return this.movimentiRepository.findAll();
    }

    @Transactional
    public MovimentiModel save(MovimentiModel movimentiModel) {
        this.movimentiRepository.addMovimento(
                movimentiModel.getCategory(),
                movimentiModel.getDate(),
                movimentiModel.getDescription(),
                movimentiModel.getValue(),
                movimentiModel.getContoOrCarta());
        return movimentiModel;
    }

    public MovimentiModel update(MovimentiModel movimentiModel) {
         this.movimentiRepository.update(
                movimentiModel.getId(),
                movimentiModel.getDescription(),
                movimentiModel.getContoOrCarta(),
                movimentiModel.getValue(),
                movimentiModel.getCategory(),
                movimentiModel.getDate()
                );
         return movimentiModel;
    }

    @Transactional
    public boolean saveAll(Map<String,List<MovimentiModel>> data) {
        for(Map.Entry<String, List<MovimentiModel>> entry : data.entrySet()) {
            for(MovimentiModel movimentiModel : entry.getValue()) {
                save(movimentiModel);
            }
        }
        return true;
    }

    public List<MovimentiModel> getMovimentiListByYearAndMonth(Integer year, Integer month) {
        return this.movimentiRepository.getMovimentiModelByMonthAndYear(year,month);
    }

    public Long delete(Long id) {
        this.movimentiRepository.delete(id);
        return id;
    }






}
