package DTO;

import models.Ticket;

import java.util.HashMap;

public class IssueTicketResponseDTO {
    private ResponseStatus responseStatus;
    private Ticket ticket;
    private String failureReason;

    public IssueTicketResponseDTO(ResponseStatus responseStatus, Ticket ticket, String failureReason) {
        this.responseStatus = responseStatus;
        this.ticket = ticket;
        this.failureReason = failureReason;
    }

    public IssueTicketResponseDTO() {
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }


    public void printDetails() {
        HashMap<String, String> ticketData = new HashMap<>();
        System.out.println("Response" + responseStatus);
        if(responseStatus.equals(ResponseStatus.FAILURE))
            System.out.println("Failure message" + failureReason);

        System.out.println("Ticket Id" + ticket.getId());
        System.out.println("Vehicle Number" + ticket.getVehicle().getNumber());
        System.out.println("Vehicle Make" +  ticket.getVehicle().getVehicleMake());
        System.out.println("Parking Spot" + ticket.getParkingSpot().getNumber());

        //LocalDateTime entryDateTime = ticket.getEntryTime();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        //System.out.println("Entry Time", entryDateTime.format(formatter));

        //return ticketData.toString();

    }
}
