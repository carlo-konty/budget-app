package org.ba.budgetapp2.businesslogic.controller;

import org.ba.budgetapp2.businesslogic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping()
    public ResponseEntity test() {
        return ResponseEntity.ok(this.testService.test());
    }

    @GetMapping("/directory")
    public ResponseEntity indexDirectory() throws IOException {
        return ResponseEntity.ok(this.testService.testDirectory());
    }


}
