package com.example.cinema.Repository;


import com.example.cinema.Entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface VilleRepository extends JpaRepository<Ville,Integer> {
}
