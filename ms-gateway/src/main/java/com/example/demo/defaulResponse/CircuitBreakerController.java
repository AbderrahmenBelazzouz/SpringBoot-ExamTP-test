package com.example.demo.defaulResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@RestController
public class CircuitBreakerController {

    @GetMapping("/defaultOrdonnances")
    public List<Ordonnance> OrdonnanceFallback() {

        List<Ordonnance> ordonnances = new ArrayList<>();
        ordonnances.add(new Ordonnance(1L, Date.valueOf("1999-01-01"), "medicament c'est 1"));
        ordonnances.add(new Ordonnance(2L, Date.valueOf("1999-01-01"), "medicament c'est 2"));

        return ordonnances;
    }

}

