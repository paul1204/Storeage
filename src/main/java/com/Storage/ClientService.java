package com.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public String signUp(Client c){
        clientRepo.save(c);
        return "Thanks for Signing up!";
    }

    public List<Client> getAll(){
        return clientRepo.findAll();
    }
}
