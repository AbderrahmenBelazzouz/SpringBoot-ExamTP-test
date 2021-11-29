package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




        import com.example.demo.DAO.patientRepository;
        import com.example.demo.entities.patient;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;

        import org.springframework.cloud.openfeign.EnableFeignClients;
        import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

        import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication implements CommandLineRunner {

    @Autowired
    patientRepository patientRepository;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(patient.class);


        patientRepository.save(new patient(null,"djamel",null,null));
        patientRepository.save(new patient(null,"salim",null,null));

    }
}
