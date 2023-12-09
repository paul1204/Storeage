package com.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    //@Autowired
    private final ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public String signUp(Client c){
        Client newClient = new Client(c.getFirstName(), c.getLastName(), c.getDriversLicenseNumber(),c.getPhone());
        clientRepo.save(newClient);
        System.out.println(newClient.toString());
        return "Thanks for Signing up!";
    }

    public List<Client> getAll(){
        return clientRepo.findAll();
    }
}
