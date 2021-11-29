package com.example.demo.Proxy;


import com.example.demo.DTO.OrdonnanceDTO;
import com.example.demo.entities.patient;
        import io.github.resilience4j.bulkhead.annotation.Bulkhead;
        import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
        import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.CollectionModel;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@FeignClient(name="ms-ordonnance")
@LoadBalancerClient(name="ms-ordonnance",configuration = LBConfiguration.class)
public interface OrdonnanceProxy {

    @GetMapping("/ordonnance/{id}")
    @Bulkhead(name="fall1", fallbackMethod = "FallbackOrdonnance")
    OrdonnanceDTO getOrdonnance(@PathVariable("id") Long ido);

    default OrdonnanceDTO FallbackOrdonnance(Long ido,Throwable throwable) {
        return new OrdonnanceDTO(1L, Date.valueOf("1999-01-01"), "il ya plusieurs medicaments");

    }


    @Query(value = "Select o.id_ordonnance, count(*) from patient p  join OrdonnanceDTO o " +
            "on p.ordonnance_id_ordonnance=o.id_ordonnance " +
            " group by o.id_ordonnance ", nativeQuery = true)
    List<Object[]> nbOrdonnancesByPatient();



    @GetMapping("/ordonnances/search/patient/{idp}")
    CollectionModel<OrdonnanceDTO> getLesOrdonnaces(@RequestParam("idp") Long idf, @RequestParam("projection") String projection);

}
