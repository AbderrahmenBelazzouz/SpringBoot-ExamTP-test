package com.example.demo.DTO;



import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdonnanceDTO {
    private Long idOrdonnance;
    private Date nom;
    private String contenu;
}
