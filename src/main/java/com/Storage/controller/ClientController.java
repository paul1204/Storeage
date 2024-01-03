package com.Storage.controller;

import com.Storage.model.Client;
import com.Storage.model.Receipt;
import com.Storage.model.Request;
import com.Storage.service.ClientService;
import com.Storage.service.RequestService;
import com.Utilites.PinGenerator;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ClientController {

    private final RequestService requestService;
    private final ClientService clientService;

    ClientController(RequestService requestService, ClientService clientService) {
        this.requestService = requestService;
        this.clientService = clientService;
    }

    @GetMapping("/")
    ResponseEntity<String> home(){
        return ResponseEntity.ok("Hello and Welcome! Thank you for choosing In-Memory Storage!");
    }

    @GetMapping("/allBookings")
    ResponseEntity<List<Request>> allReservations(){
        return ResponseEntity.ok(requestService.allReservations());
    }

    @GetMapping("/allClients")
    ResponseEntity<List<Client>> allClients(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @PostMapping("/signUp")
    ResponseEntity signUp(@RequestBody Client c){
        clientService.signUp(c);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/viewAccount")
    ResponseEntity<String> inquire(){
        return ResponseEntity.ok("");
    }

    @PostMapping("/book")
    ResponseEntity book(@RequestBody Request r){
        //Generate a Pin for the Customer.
        //This Pin will allow them to come and go
        //Load the DB with some values for the different Storage room
        //A: Basic Package
        //B: Size
        //C: Price
        //Update the Client Record with the reservation they made... with the ID of the Request
        //The ID of the reservation they made will point to the actual reservation they made (Storage Room Info)
        //Model the Data. See how it will flow
        requestService.makeReservation(r);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}