package service;

import models.*;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import strategy.spotAllocationStrategy.SpotAllocationFactory;
import strategy.spotAllocationStrategy.SpotAllocationStrategy;

import java.time.LocalDateTime;

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
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setNumber(vehicleNumber);
        vehicle.setVehicleMake(vehicleMake);
        vehicle.setColor(vehicleColor);
        Gate gate = gateRepository.get(gateId);
        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationFactory.getSpotAllocationStrategy(parkingLotRepository);
        ParkingSpot parkingSpot = spotAllocationStrategy.getSpot(vehicle,gate);
        parkingSpot.setStatus(Status.NOT_AVAILABLE);

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setVehicle(vehicle);
        return ticket;
    }
}
