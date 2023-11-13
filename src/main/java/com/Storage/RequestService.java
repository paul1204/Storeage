package com.Storage;

import com.Utilites.PinGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    Request request;
    private final RequestRepository requestRepository;

    private ReceiptRepository receiptRepo;
    PinGenerator pinGen = new PinGenerator();


    public RequestService(RequestRepository requestRepository, ReceiptRepository receiptRepo) {
        this.requestRepository = requestRepository;

        this.receiptRepo = receiptRepo;
    }

    public Receipt makeReservation(Request r){
        System.out.println(r.toString());

        //Call the Room Repo. Make sure there is a vacant spot before making reservations...
        this.requestRepository.save(r);
       //return "thanks!" + "Your pin is:" + pinGen.generatePin();
        Receipt receipt = r.generateReceipt();
        receiptRepo.save(receipt);
        return receipt;
    }
    public List<Request> allReservations(){
        return requestRepository.findAll();
    }

}
