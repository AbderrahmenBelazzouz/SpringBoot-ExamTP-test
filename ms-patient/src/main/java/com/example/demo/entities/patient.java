package com.example.demo.entities;

import com.example.demo.DTO.OrdonnanceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String nom;

    private Long idOrdonnance;

    @Transient
  private List<OrdonnanceDTO> ordonnances;

}
