package com.example.demo.defaulResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Ordonnance {

    private Long idOrdonnance;
    private Date date;
    private String contenu;
}
