package service;

import Entities.NationalRoute;
import Entities.InternationalRoute;
import Entities.Route;
import repository.RouteRepository;
import java.util.ArrayList;

public class RouteService {

    RouteRepository routeRepo = new RouteRepository();

    public void createDomesticRoute(String routeCode, String originCity, String destinationCity,
                                    String departureDate, String departureTime, String arrivalTime,
                                    int totalSeats, double basePrice,
                                    double durationHours, boolean hasRestStops) throws Exception {

        if (routeRepo.findByCode(routeCode) != null) {
            throw new Exception("Ya existe una ruta con ese código");
        }
        if (totalSeats <= 0) {
            throw new Exception("El número de puestos debe ser mayor a 0");
        }
        if (totalSeats > 32) {
            throw new Exception("El número de puestos no puede superar 32");
        }
        if (basePrice <= 0) {
            throw new Exception("El precio de la ruta debe ser mayor a cero");
        }

        NationalRoute route = new NationalRoute(routeCode, originCity, destinationCity,
                departureDate, departureTime, arrivalTime,
                totalSeats, basePrice, durationHours, hasRestStops);
        routeRepo.add(route);
        System.out.println(" Ruta nacional creada exitosamente.");
        System.out.println("  Precio final: $" + route.calculateFinalPrice());
    }

    public void createInternationalRoute(String routeCode, String originCity, String destinationCity,
                                         String departureDate, String departureTime, String arrivalTime,
                                         int totalSeats, double basePrice,
                                         String destinationCountry, boolean requiresPassport,
                                         double internationalFee) throws Exception {

        if (routeRepo.findByCode(routeCode) != null) {
            throw new Exception("Ya existe una ruta con ese código");
        }
        if (totalSeats <= 0) {
            throw new Exception("El número de puestos debe ser mayor a 0");
        }
        if (totalSeats > 32) {
            throw new Exception("El número de puestos no puede superar 32");
        }
        if (basePrice <= 0) {
            throw new Exception("El precio de la ruta debe ser mayor a cero");
        }

        InternationalRoute route = new InternationalRoute(routeCode, originCity, destinationCity,
                departureDate, departureTime, arrivalTime,
                totalSeats, basePrice, destinationCountry,
                requiresPassport, internationalFee);
        routeRepo.add(route);
        System.out.println(" Ruta internacional creada exitosamente.");
        System.out.println("  Precio final: $" + route.calculateFinalPrice());
    }

    public Route findRoute(String routeCode) throws Exception {
        Route r = routeRepo.findByCode(routeCode);
        if (r == null) {
            throw new Exception("No se encontró ninguna ruta con ese código");
        }
        return r;
    }

    public void listAllRoutes() {
        ArrayList<Route> routes = routeRepo.getAll();
        if (routes.isEmpty()) {
            System.out.println("No hay rutas registradas.");
            return;
        }
        for (Route r : routes) {
            System.out.println(r);
        }
    }
}