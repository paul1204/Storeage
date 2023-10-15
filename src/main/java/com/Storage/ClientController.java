package com.Storage;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ClientController {
    private final ClientRepository clientRepo;
    private final RequestRepository requestRepository;


    ClientController(ClientRepository clientRepo, RequestRepository requestRepository) {
        this.clientRepo = clientRepo;
        this.requestRepository = requestRepository;
    }

    @GetMapping("/")
    String home(){
        return "Hello and Welcome! Thank you for choosing In-Memory Storage!";
    }

    @GetMapping("/allBookings")
    List<Request> allReservations(){
            return requestRepository.findAll();
    }

    @GetMapping("/allClients")
    List<Client> allClients(){
        return clientRepo.findAll();
    }

    @PostMapping("/signUp")
    String signUp(@RequestBody Client c){
    clientRepo.save(c);
        return "Thanks for Signing up!";
    }

    @PostMapping("/book")
    String book(@RequestBody Request r){
        requestRepository.save(r);
        //Generate a Pin for the Customer.
        //This Pin will allow them to come and go
        //Load the DB with some values for the different Storage room
        //A: Basic Package
        //B: Size
        //C: Price

        
        return "Thanks for Reserving a Storage Room!";
    }

    //
}
