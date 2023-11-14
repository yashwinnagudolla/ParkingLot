import DTO.IssueTicketRequestDTO;
import DTO.IssueTicketResponseDTO;
import controller.TicketController;
import models.VehicleType;
import repository.*;
import service.InitialisationService;
import service.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private InitialisationService initialisationService;
    private TicketController ticketController;

    public Main(){
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();


        this.initialisationService = new InitialisationService();
        this.ticketController = new TicketController(new TicketService(ticketRepository,parkingLotRepository,gateRepository));


    }
    public static void main(String[] args) {
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setGateId(1);
        issueTicketRequestDTO.setVehicleColor("Black");
        issueTicketRequestDTO.setVehicleMake("SUV");
        issueTicketRequestDTO.setVehicleNumber("12345");
        issueTicketRequestDTO.setVehicleType(VehicleType.FOUR_WHEELER);

        Main main = new Main();
        main.initialisationService.initialise();
        IssueTicketResponseDTO issueTicketResponseDTO = main.ticketController.getTicket(issueTicketRequestDTO);
        issueTicketResponseDTO.printDetails();

    }
}