package org.ba.budgetapp2.businesslogic.controller;

import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.service.MovimentiService;
import org.ba.budgetapp2.businesslogic.service.intesa.IntesaXlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/movimenti")
public class MovimentiController {

    @Autowired
    private MovimentiService movimentiService;

    @Autowired
    private IntesaXlsService intesaXlsService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.movimentiService.getAll());
    }

    @GetMapping("by")
    public ResponseEntity<?> getByMonthAndOrYear(@RequestParam("year") Integer year, @RequestParam(value = "month",required = false) Integer month) {
        return ResponseEntity.ok(this.movimentiService.getMovimentiListByYearAndMonth(year, month));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody() MovimentiModel movimentiModel) {
        return ResponseEntity.ok(this.movimentiService.save(movimentiModel));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody() MovimentiModel movimentiModel) {
        return ResponseEntity.ok(this.movimentiService.update(movimentiModel));
    }

    @GetMapping("/run")
    public ResponseEntity<?> run() throws IOException {
        return ResponseEntity.ok(this.movimentiService.saveAll(intesaXlsService.iterateOverFolder()));
    }

    @GetMapping("/write")
    public ResponseEntity<?> write(@RequestParam("year") Integer year, @RequestParam("month") Integer month) throws IOException {
        return ResponseEntity.ok(this.intesaXlsService.writeToXlsModel(year, month));
    }

}
