package com.Storage.service;

import com.Storage.repository.ClientRepository;
import com.Storage.model.Receipt;
import com.Storage.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    //@Autowired
    private final ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public String signUp(Client c){
        List<Receipt> receipts = new ArrayList<>();
        int id = 1000;
        Client newClient = new Client(id,c.getFirstName(), c.getLastName(), c.getDriversLicenseNumber(),c.getPhone(), receipts);
        clientRepo.save(newClient);
        System.out.println(newClient.toString());
        return "Thanks for Signing up!";
    }

    public List<Client> getAll(){
        return clientRepo.findAll();
    }
}
