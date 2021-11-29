package com.example.demo.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



import com.example.demo.DAO.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@RepositoryRestResource
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {



        @Query(value = "Select f.id_formation, count(*) from etudiant e  join formation f " +
                "on e.formation_id_formation=f.id_formation " +
                " group by f.id_formation ", nativeQuery = true)
        List<Object[]> nbEtudiantsByFormation();
}
