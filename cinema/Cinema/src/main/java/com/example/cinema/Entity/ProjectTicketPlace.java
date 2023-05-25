package com.example.cinema.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

@org.springframework.data.rest.core.config.Projection(name = "ticketProj",types = {Ticket.class})
public interface ProjectTicketPlace {

    public int getId();
    public String getNomCLient();
    public double getPrix();
    public Integer getCodePayement();
    public boolean isReserve();
    public Place getPlace();

}
