package repository;

import Entities.Reservation;
import java.util.ArrayList;

public class ReservationRepository {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void add(Reservation reservation) {
        reservations.add(reservation);
    }

    public Reservation findByCode(String reservationCode) {
        for (Reservation b : reservations) {
            if (b.getReservationCode().equals(reservationCode)) return b;
        }
        return null;
    }

    public ArrayList<Reservation> findByPassengerIdNumber(String idNumber) {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation b : reservations) {
            if (b.getPassenger().getIdNumber().equals(idNumber)) {
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<Reservation> getAll() {
        return reservations;
    }
}
