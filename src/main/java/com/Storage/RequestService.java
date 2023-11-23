package com.Storage;

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

    PinGenerator pinGen = new PinGenerator();


    public RequestService(RequestRepository requestRepository, ReceiptRepository receiptRepo, RoomRepository roomRepo) {
        this.requestRepository = requestRepository;
        this.receiptRepo = receiptRepo;
        this.roomRepo = roomRepo;
    }

    public Receipt makeReservation(Request req){
        System.out.println(req.toString());
        Optional<Room> room = roomRepo.findById(req.getRoomId(0));
        Room roo = room.orElseThrow();
            if(checkSpots(roo)){
                this.requestRepository.save(req);
                Receipt receipt = req.generateReceipt(req.getIdUser(),roo.getPrice());
                receiptRepo.save(receipt);
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
