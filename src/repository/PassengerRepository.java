package repository;

import Entities.Passenger;
import java.util.ArrayList;

public class PassengerRepository {

    private ArrayList<Passenger> passengers = new ArrayList<>();

    public void add(Passenger passenger) {
        passengers.add(passenger);
    }

    public Passenger findByIdNumber(String idNumber) {
        for (Passenger p : passengers) {
            if (p.getIdNumber().equals(idNumber)) return p;
        }
        return null;
    }

    public Passenger findByPassport(String passportNumber) {
        for (Passenger p : passengers) {
            if (p.getPassportNumber().equals(passportNumber)) return p;
        }
        return null;
    }

    public int count() {
        return passengers.size();
    }

    public ArrayList<Passenger> getAll() {
        return passengers;
    }
}
