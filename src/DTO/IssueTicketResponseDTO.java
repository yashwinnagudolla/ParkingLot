package DTO;

import models.Ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Override
    public String toString() {
        HashMap<String, String> ticketData = new HashMap<>();
        ticketData.put("Response", responseStatus.toString());
        if(responseStatus.equals(ResponseStatus.FAILURE))
            ticketData.put("Failure message", failureReason);

        ticketData.put("Ticket Id", String.valueOf(ticket.getId()));
        ticketData.put("Vehicle Number", ticket.getVehicle().getNumber());
        ticketData.put("Vehicle Make", ticket.getVehicle().getVehicleMake());
        ticketData.put("Parking Spot", String.valueOf(ticket.getParkingSpot().getNumber()));

        LocalDateTime entryDateTime = ticket.getEntryTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        ticketData.put("Entry Time", entryDateTime.format(formatter));

        return ticketData.toString();

    }
}
