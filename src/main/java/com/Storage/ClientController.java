package com.Storage;

import com.Utilites.PinGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ClientController {
    private final ClientRepository clientRepo;
   // private final RequestRepository requestRepository;

    private final RequestService requestService;
    private final ClientService clientService;

    PinGenerator pinGen = new PinGenerator();


    ClientController(ClientRepository clientRepo, RequestService requestService, ClientService clientService) {
        this.clientRepo = clientRepo;
      //  this.requestRepository = requestRepository;
        this.requestService = requestService;
        this.clientService = clientService;
    }

    @GetMapping("/")
    String home(){
        return "Hello and Welcome! Thank you for choosing In-Memory Storage!";
    }

    @GetMapping("/allBookings")
    List<Request> allReservations(){
            return requestService.allReservations();
    }

    @GetMapping("/allClients")
    List<Client> allClients(){
        return clientService.getAll();
    }

    @PostMapping("/signUp")
    String signUp(@RequestBody Client c){
        return clientService.signUp(c);
    }

    @PostMapping("/book")
    Receipt book(@RequestBody Request r){
        //Generate a Pin for the Customer.
        //This Pin will allow them to come and go
        //Load the DB with some values for the different Storage room
        //A: Basic Package
        //B: Size
        //C: Price

        //Update the Client Record with the reservation they made... with the ID of the Request
        //The ID of the reservation they made will point to the actual reservation they made (Storage Room Info)
        //Model the Data. See how it will flow
        return requestService.makeReservation(r);
    }

    //
}
