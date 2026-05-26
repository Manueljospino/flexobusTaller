package Entities;

public class Reservation {

    private String reservationCode;
    private Passenger passenger;
    private Route route;
    private int seatsReserved;
    private String reservationDate;
    private double totalPrice;
    private String status;  // "Confirmed", "Cancelled", "Completed"

    public Reservation(String reservationCode, Passenger passenger, Route route,
                       int seatsReserved, String reservationDate) {
        this.reservationCode = reservationCode;
        this.passenger = passenger;
        this.route = route;
        this.seatsReserved = seatsReserved;
        this.reservationDate = reservationDate;
        this.totalPrice = route.calculateFinalPrice() * seatsReserved;
        this.status = "Confirmed";
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(int seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n--- RESERVATION INFO ---" +
                "\nReservation Code  : " + reservationCode +
                "\nPassenger     : " + passenger.getFirstName() + " " + passenger.getLastName() +
                "\nID Number     : " + passenger.getIdNumber() +
                "\nRoute         : " + route.getOriginCity() + " → " + route.getDestinationCity() +
                "\nRoute Code    : " + route.getRouteCode() +
                "\nSeats         : " + seatsReserved +
                "\nReservation Date  : " + reservationDate +
                "\nTotal Price   : $" + totalPrice +
                "\nStatus        : " + status;
    }
}

