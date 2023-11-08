package service;

import models.Gate;
import models.Ticket;
import models.VehicleType;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }

    public Ticket getTicket(VehicleType vehicleType, String vehicleNumber, String vehicleColor, String vehicleMake,int gateId){
        Gate gate = gateRepository.get(gateId);
    }
}
