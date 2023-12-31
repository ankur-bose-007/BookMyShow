package model;

import java.util.Date;

public class Ticket {
    private static int idCounter = 0;
    private int id;
    private String ownerName;
    private Date bookingTime;
    private int noOfSeats;
    private String theater;

    public Ticket(String ownerName, Date bookingTime, int noOfSeats, String theater) {
        idCounter+=1;
        this.id = idCounter;
        this.ownerName = ownerName;
        this.bookingTime = bookingTime;
        this.noOfSeats = noOfSeats;
        this.theater = theater;
    }

    public String getTicketInfo(){
        return "Ticket booked for: " + this.ownerName + " Number of seats booked : " + this.noOfSeats +
                "in theater: " + this.theater;
    }

    public int cancelTicket(){
        this.theater = null;
        this.ownerName = null;
        this.noOfSeats = 0;

        System.out.println("Ticket got cancelled successfully");

        return 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
