package service;

import Entities.Passenger;
import repository.PassengerRepository;

public class PassengerService {

    PassengerRepository passengerRepo = new PassengerRepository();

    public void registerPassenger(String idNumber, String firstName, String lastName,
                                  int age, String email, String phone,
                                  String passportNumber, String nationality) throws Exception {

        if (passengerRepo.findByIdNumber(idNumber) != null) {
            throw new Exception("Ya existe un pasajero con ese número de cédula");
        }

        if (passengerRepo.findByPassport(passportNumber) != null) {
            throw new Exception("Ya existe un pasajero con ese número de pasaporte");
        }

        if (!email.contains("@")) {
            throw new Exception("El correo electrónico debe contener el símbolo @");
        }

        if (age < 0) {
            throw new Exception("La edad no puede ser negativa");
        }

        Passenger newPassenger = new Passenger(idNumber, firstName, lastName,
                age, email, phone, passportNumber, nationality);
        passengerRepo.add(newPassenger);
        System.out.println(" Pasajero registrado exitosamente.");
    }

    public Passenger findPassenger(String idNumber) throws Exception {
        Passenger p = passengerRepo.findByIdNumber(idNumber);
        if (p == null) {
            throw new Exception("No se encontró ningún pasajero con ese número de cédula");
        }
        return p;
    }

    public void showTotalPassengers() {
        System.out.println("Total de pasajeros registrados: " + passengerRepo.count());
    }
}