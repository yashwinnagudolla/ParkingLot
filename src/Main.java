import DTO.IssueTicketRequestDTO;
import DTO.IssueTicketResponseDTO;
import controller.TicketController;
import models.VehicleType;
import service.InitialisationService;
import service.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setGateId(1);
        issueTicketRequestDTO.setVehicleColor("Black");
        issueTicketRequestDTO.setVehicleMake("SUV");
        issueTicketRequestDTO.setVehicleNumber("12345");
        issueTicketRequestDTO.setVehicleType(VehicleType.FOUR_WHEELER);

        InitialisationService initialisationService = new InitialisationService();
        initialisationService.initialise();
        TicketController ticketController = new TicketController(new TicketService());
        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.getTicket(issueTicketRequestDTO);
    }
}