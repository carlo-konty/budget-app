package org.ba.budgetapp2.businesslogic.controller;

import org.ba.budgetapp2.businesslogic.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public ResponseEntity getAllCategories() {
        return ResponseEntity.ok(this.categorieService.getAll());
    }
}
