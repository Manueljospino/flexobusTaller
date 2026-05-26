package Menu;

import service.ReservationService;
import service.PassengerService;
import service.RouteService;
import java.util.Scanner;

public class Menu {

    PassengerService passengerService;
    RouteService routeService;
    ReservationService reservationService;
    Scanner scanner = new Scanner(System.in);

    public Menu(PassengerService passengerService,
                RouteService routeService,
                ReservationService reservationService) {
        this.passengerService = passengerService;
        this.routeService = routeService;
        this.reservationService = reservationService;
    }

    public void showMainMenu() {
        int option = -1;
        do {
            System.out.println("\n=============================");
            System.out.println("   SISTEMA FLUXIOBUS COLOMBIA");
            System.out.println("=============================");
            System.out.println("1. Registrar Pasajero");
            System.out.println("2. Buscar Pasajero");
            System.out.println("3. Total de Pasajeros");
            System.out.println("4. Crear Ruta Nacional");
            System.out.println("5. Crear Ruta Internacional");
            System.out.println("6. Listar Todas las Rutas");
            System.out.println("7. Crear Reserva");
            System.out.println("8. Cancelar Reserva");
            System.out.println("9. Buscar Reserva por Código");
            System.out.println("10. Listar Reservas por Pasajero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                handleOption(option);
            } catch (NumberFormatException e) {
                System.out.println("Error: por favor ingrese un número válido.");
            }

        } while (option != 0);

        System.out.println("¡Hasta luego!");
    }

    public void handleOption(int option) {
        switch (option) {
            case 1 -> registerPassenger();
            case 2 -> findPassenger();
            case 3 -> passengerService.showTotalPassengers();
            case 4 -> createDomesticRoute();
            case 5 -> createInternationalRoute();
            case 6 -> routeService.listAllRoutes();
            case 7 -> createReservation();
            case 8 -> cancelReservation();
            case 9 -> findReservation();
            case 10 -> listReservationsByPassenger();
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

    public void registerPassenger() {
        System.out.println("\n--- REGISTRAR PASAJERO ---");
        try {
            System.out.print("Número de cédula  : "); String idNumber = scanner.nextLine();
            System.out.print("Nombre            : "); String firstName = scanner.nextLine();
            System.out.print("Apellido          : "); String lastName = scanner.nextLine();
            System.out.print("Edad              : "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Correo electrónico: "); String email = scanner.nextLine();
            System.out.print("Teléfono          : "); String phone = scanner.nextLine();
            System.out.print("N° de pasaporte   : "); String passport = scanner.nextLine();
            System.out.print("Nacionalidad      : "); String nationality = scanner.nextLine();

            passengerService.registerPassenger(idNumber, firstName, lastName,
                    age, email, phone, passport, nationality);
        } catch (NumberFormatException e) {
            System.out.println("Error: la edad debe ser un número válido.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void findPassenger() {
        System.out.println("\n--- BUSCAR PASAJERO ---");
        try {
            System.out.print("Número de cédula: "); String idNumber = scanner.nextLine();
            System.out.println(passengerService.findPassenger(idNumber));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createDomesticRoute() {
        System.out.println("\n--- CREAR RUTA NACIONAL ---");
        try {
            System.out.print("Código de ruta       : "); String code = scanner.nextLine();
            System.out.print("Ciudad de origen     : "); String origin = scanner.nextLine();
            System.out.print("Ciudad de destino    : "); String destination = scanner.nextLine();
            System.out.print("Fecha de salida      : "); String date = scanner.nextLine();
            System.out.print("Hora de salida       : "); String depTime = scanner.nextLine();
            System.out.print("Hora de llegada      : "); String arrTime = scanner.nextLine();
            System.out.print("Total de puestos     : "); int seats = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio base          : "); double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Duración (horas)     : "); double duration = Double.parseDouble(scanner.nextLine());
            System.out.print("Paradas de descanso (s/n): "); boolean restStops = scanner.nextLine().equalsIgnoreCase("s");

            routeService.createDomesticRoute(code, origin, destination, date,
                    depTime, arrTime, seats, price,
                    duration, restStops);
        } catch (NumberFormatException e) {
            System.out.println("Error: los campos numéricos deben contener valores válidos.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createInternationalRoute() {
        System.out.println("\n--- CREAR RUTA INTERNACIONAL ---");
        try {
            System.out.print("Código de ruta          : "); String code = scanner.nextLine();
            System.out.print("Ciudad de origen        : "); String origin = scanner.nextLine();
            System.out.print("Ciudad de destino       : "); String destination = scanner.nextLine();
            System.out.print("Fecha de salida         : "); String date = scanner.nextLine();
            System.out.print("Hora de salida          : "); String depTime = scanner.nextLine();
            System.out.print("Hora de llegada         : "); String arrTime = scanner.nextLine();
            System.out.print("Total de puestos        : "); int seats = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio base             : "); double price = Double.parseDouble(scanner.nextLine());
            System.out.print("País de destino         : "); String country = scanner.nextLine();
            System.out.print("Requiere pasaporte (s/n): "); boolean passport = scanner.nextLine().equalsIgnoreCase("s");
            System.out.print("Tarifa internacional    : "); double fee = Double.parseDouble(scanner.nextLine());

            routeService.createInternationalRoute(code, origin, destination, date,
                    depTime, arrTime, seats, price,
                    country, passport, fee);
        } catch (NumberFormatException e) {
            System.out.println("Error: los campos numéricos deben contener valores válidos.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createReservation() {
        System.out.println("\n--- CREAR RESERVA ---");
        try {
            System.out.print("Código de reserva : "); String reservationCode = scanner.nextLine();
            System.out.print("Cédula del pasajero: "); String idNumber = scanner.nextLine();
            System.out.print("Código de ruta    : "); String routeCode = scanner.nextLine();
            System.out.print("Puestos           : "); int seats = Integer.parseInt(scanner.nextLine());
            System.out.print("Fecha de reserva  : "); String date = scanner.nextLine();

            reservationService.createReservation(reservationCode, idNumber, routeCode, seats, date);
        } catch (NumberFormatException e) {
            System.out.println("Error: el número de puestos debe ser un valor válido.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cancelReservation() {
        System.out.println("\n--- CANCELAR RESERVA ---");
        try {
            System.out.print("Código de reserva: "); String reservationCode = scanner.nextLine();
            reservationService.cancelReservation(reservationCode);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void findReservation() {
        System.out.println("\n--- BUSCAR RESERVA ---");
        try {
            System.out.print("Código de reserva: "); String reservationCode = scanner.nextLine();
            reservationService.findReservationByCode(reservationCode);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listReservationsByPassenger() {
        System.out.println("\n--- RESERVAS POR PASAJERO ---");
        try {
            System.out.print("Cédula del pasajero: "); String idNumber = scanner.nextLine();
            reservationService.listReservationsByPassenger(idNumber);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
