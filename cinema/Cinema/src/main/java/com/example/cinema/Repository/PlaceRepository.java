package com.example.cinema.Repository;


import com.example.cinema.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface PlaceRepository extends JpaRepository<Place,Integer> {
}
