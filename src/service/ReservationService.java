package service;

import Entities.Reservation;
import Entities.InternationalRoute;
import Entities.Passenger;
import Entities.Route;
import repository.ReservationRepository;
import repository.PassengerRepository;
import repository.RouteRepository;
import java.util.ArrayList;

public class ReservationService {

    PassengerRepository passengerRepo = new PassengerRepository();
    RouteRepository routeRepo = new RouteRepository();
    ReservationRepository reservationRepo = new ReservationRepository();

    public void createReservation(String reservationCode, String idNumber,
                                  String routeCode, int seats,
                                  String reservationDate) throws Exception {

        if (reservationRepo.findByCode(reservationCode) != null) {
            throw new Exception("Ya existe una reserva con ese código");
        }

        Passenger passenger = passengerRepo.findByIdNumber(idNumber);
        if (passenger == null) {
            throw new Exception("No se encontró ningún pasajero con ese número de cédula");
        }

        Route route = routeRepo.findByCode(routeCode);
        if (route == null) {
            throw new Exception("No se encontró ninguna ruta con ese código");
        }

        if (!route.getStatus().equals("Scheduled")) {
            throw new Exception("La ruta no está disponible para reservas (debe estar en estado Programada)");
        }

        if (seats < 1 || seats > 5) {
            throw new Exception("No se pueden reservar más de 5 puestos por reserva");
        }

        if (route.getAvailableSeats() < seats) {
            throw new Exception("No hay suficientes puestos disponibles en esta ruta");
        }

        if (route instanceof InternationalRoute) {
            InternationalRoute intlRoute = (InternationalRoute) route;
            if (intlRoute.isRequiresPassport() && passenger.getPassportNumber().isEmpty()) {
                throw new Exception("El pasajero necesita pasaporte para esta ruta internacional");
            }
        }

        Reservation reservation = new Reservation(reservationCode, passenger, route, seats, reservationDate);
        reservationRepo.add(reservation);
        route.reduceSeats(seats);

        System.out.println(" Reserva creada exitosamente.");
        System.out.println(reservation);
    }

    public void cancelReservation(String reservationCode) throws Exception {
        Reservation reservation = reservationRepo.findByCode(reservationCode);
        if (reservation == null) {
            throw new Exception("No se encontró ninguna reserva con ese código");
        }
        if (reservation.getStatus().equals("Cancelled")) {
            throw new Exception("Esta reserva ya se encuentra cancelada");
        }

        reservation.setStatus("Cancelled");
        reservation.getRoute().returnSeats(reservation.getSeatsReserved());

        System.out.println(" Reserva cancelada. Puestos devueltos a la ruta.");
    }

    public void findReservationByCode(String reservationCode) throws Exception {
        Reservation reservation = reservationRepo.findByCode(reservationCode);
        if (reservation == null) {
            throw new Exception("No se encontró ninguna reserva con ese código");
        }
        System.out.println(reservation);
    }

    public void listReservationsByPassenger(String idNumber) throws Exception {
        Passenger passenger = passengerRepo.findByIdNumber(idNumber);
        if (passenger == null) {
            throw new Exception("No se encontró ningún pasajero con ese número de cédula");
        }

        ArrayList<Reservation> reservations = reservationRepo.findByPassengerIdNumber(idNumber);
        if (reservations.isEmpty()) {
            System.out.println("No se encontraron reservas para este pasajero.");
            return;
        }
        for (Reservation b : reservations) {
            System.out.println(b);
        }
    }
}