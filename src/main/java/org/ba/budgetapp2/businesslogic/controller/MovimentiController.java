package org.ba.budgetapp2.businesslogic.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody() Long id) {
        return ResponseEntity.ok(this.movimentiService.delete(id));
    }

    @GetMapping("/run")
    public ResponseEntity<?> run() throws IOException {
        return ResponseEntity.ok(this.movimentiService.saveAll(intesaXlsService.iterateOverFolder()));
    }

    @GetMapping("/run/by")
    public ResponseEntity<?> runByYearAndMonth(@RequestParam(name = "year", required = false) Integer year,
                                               @RequestParam(name = "month", required = false) Integer month,
                                               @RequestParam(name = "file", required = false) String fileName) throws IOException {
        return ResponseEntity.ok(this.movimentiService.saveAll(intesaXlsService.iterateOverFolderByYearAndMonth(year,month,fileName)));
    }

    @GetMapping("/write/by")
    public ResponseEntity<?> write(@RequestParam("year") String year, @RequestParam("month") String month) throws IOException {
        log.info("year: {}, month: {}", year, month);
        return ResponseEntity.ok(intesaXlsService.writeToXlsModel(Integer.valueOf(year), Integer.valueOf(month)));
    }

}
