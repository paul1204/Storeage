package com.Storage.service;

import com.Storage.model.Room;
import com.Storage.repository.RoomRepository;
import com.Storage.model.Client;
import com.Storage.model.Receipt;
import com.Storage.model.Request;
import com.Storage.repository.ClientRepository;
import com.Storage.repository.ReceiptRepository;
import com.Storage.repository.RequestRepository;
import com.Utilites.PinGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    Request request;
    private final RequestRepository requestRepository;
    private final ReceiptRepository receiptRepo;
    private final RoomRepository roomRepo;
    private final ClientRepository clientRepo;

    PinGenerator pinGen = new PinGenerator();


    public RequestService(RequestRepository requestRepository, ReceiptRepository receiptRepo, RoomRepository roomRepo, ClientRepository clientRepo) {
        this.requestRepository = requestRepository;
        this.receiptRepo = receiptRepo;
        this.roomRepo = roomRepo;
        this.clientRepo = clientRepo;
    }

    public Receipt makeReservation(Request req){
        System.out.println(req.toString());
        Optional<Room> roomOptional = roomRepo.findById(req.getRoomId(0));
        Room room = roomOptional.orElseThrow();
        Optional<Client> clientOptional = clientRepo.findById(req.getIdUser());
        Client c = clientOptional.orElseThrow();
            if(checkSpots(room)){
                double cost = req.generateCost(room.getPrice(), req.getMonthsToRent());
                Receipt receipt = req.generateReceipt(req.getIdUser(),cost);
                String pin = pinGen.generatePin(Long.toString(req.getIdUser()), Long.toString(req.getId()), room.getAvailableRooms());
                receipt.setPin(pin);
                req.setReceipt(receipt.getUid());
                receiptRepo.save(receipt);
                c.addReceipt(receipt);
                this.requestRepository.save(req);
                room.setAvailableRooms(room.getAvailableRooms() - 1);
                System.out.println(room.getAvailableRooms());
                roomRepo.save(room);
                return receipt;
            }
        //Call the Room Repo. Make sure there is a vacant spot before making reservations...

        //Need to change this...
        //Should be handled better than return null
        return null;
    }

    private boolean checkSpots(Room r){
        return r.getAvailableRooms() > 0;
        //System.out.println(r.toString());
    }

    public List<Request> allReservations(){
        return requestRepository.findAll();
    }

}
