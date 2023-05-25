package com.example.cinema.Repository;

import com.example.cinema.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// Rest Api
@RepositoryRestResource
//  restricts web pages from making requests to a different domain than the one that served the page
@CrossOrigin("*")

public interface CategoryRepository extends JpaRepository<Categorie,Integer> {
}
