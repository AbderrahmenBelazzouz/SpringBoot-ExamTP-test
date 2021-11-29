package com.example.demo.DAO;


import com.example.demo.entities.patient;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;

        import java.util.List;

@RepositoryRestResource
public interface patientRepository extends JpaRepository<patient, Long> {

    List<patient> findPatientByIdOrdonnance(Long ido);
}
