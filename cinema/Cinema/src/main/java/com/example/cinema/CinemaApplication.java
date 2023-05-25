package com.example.cinema;

import com.example.cinema.Entity.Film;
import com.example.cinema.Entity.Salle;
import com.example.cinema.Entity.Ticket;
import com.example.cinema.Service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner{

    @Autowired
    private ICinemaInitService cinemaInitService;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Film.class); // inclure id dans json
        restConfiguration.exposeIdsFor(Salle.class); // inclure id dans json
        restConfiguration.exposeIdsFor(Ticket.class); // inclure id dans json
        cinemaInitService.initVille();
        cinemaInitService.initCinema();
        cinemaInitService.initSalles();
        cinemaInitService.initPlaces();
        cinemaInitService.initSeances();
        cinemaInitService.initCategories();
        cinemaInitService.initFilm();
        cinemaInitService.initProjections();
        cinemaInitService.initTickets();
    }
}
