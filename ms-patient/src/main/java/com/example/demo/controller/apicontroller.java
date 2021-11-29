package com.example.demo.controller;




import com.example.demo.DTO.OrdonnanceDTO;
        import com.example.demo.DAO.patientRepository;
        import com.example.demo.entities.patient;
        import com.example.demo.Proxy.OrdonnanceProxy;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;

@RestController
@RequestMapping("api")
public class apicontroller {

    @Autowired
    patientRepository patientRepository;
    @Qualifier("")
    @Autowired
    OrdonnanceProxy ordonnanceProxy;

    @GetMapping("/ordonnances/patient/{id}")
    public List<OrdonnanceDTO> getOrdonnanceswithpatient(@PathVariable("id") Long idp)
    {
        patient patient=patientRepository.findById(idp).get();


       // OrdonnanceDTO ordonnance= ordonnanceProxy.getLesOrdonnaces(patient.getIdOrdonnance());
        List<OrdonnanceDTO> ordonnances = patient.getOrdonnances();


        return  ordonnances;
    }








}