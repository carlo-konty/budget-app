package org.ba.budgetapp2.businesslogic.controller;

import org.ba.budgetapp2.businesslogic.entities.CategorieModel;
import org.ba.budgetapp2.businesslogic.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public ResponseEntity getAllCategories() {
        return ResponseEntity.ok(this.categorieService.getAll());
    }


    @GetMapping("by")
    public ResponseEntity getCategorieByTypeAndName(@RequestParam(required = false) String type, @RequestParam(required = false) String name) {
        return ResponseEntity.ok(this.categorieService.getByTypeAndName(type,name));
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody CategorieModel categorieModel) {
        this.categorieService.save(categorieModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/all")
    public ResponseEntity saveAll() {
        return ResponseEntity.ok(this.categorieService.saveAll());
    }
}
