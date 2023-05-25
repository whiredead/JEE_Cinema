package com.example.cinema.Web;

import com.example.cinema.Entity.Film;
import com.example.cinema.Entity.Ticket;
import com.example.cinema.Repository.FilmRepository;
import com.example.cinema.Repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping(path="/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name="id") int id) throws Exception{
        Film f = filmRepository.findById(id).get();
        String photoName=f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/Desktop/cinema/movies/"+photoName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/payerTickets")
    @Transactional
    public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm){
        List<Ticket> ListTickets = new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket->{
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNomCLient(ticketForm.getNomClient());
            ticket.setReserve(true);
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticketRepository.save(ticket);
            ListTickets.add(ticket);
        });
        return ListTickets;
    }
}

@Data
class TicketForm{
    private String nomClient;
    private Integer codePayement;
    private List<Integer> tickets= new ArrayList<>();
}
