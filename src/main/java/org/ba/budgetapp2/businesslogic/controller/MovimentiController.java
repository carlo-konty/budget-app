package org.ba.budgetapp2.businesslogic.controller;

import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.service.MovimentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movimenti")
public class MovimentiController {

    @Autowired
    private MovimentiService movimentiService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.movimentiService.getAll());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody()MovimentiModel movimentiModel) {
        return ResponseEntity.ok(this.movimentiService.save(movimentiModel));
    }

    @GetMapping("/run")
    public ResponseEntity<?> run() {
        return ResponseEntity.ok(this.movimentiService.saveAll());
    }

}
