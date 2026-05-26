package Main;

import Menu.Menu;
import service.ReservationService;
import service.PassengerService;
import service.RouteService;

public class Main {

    public static void main(String[] args) {


        PassengerService passengerService     = new PassengerService();
        RouteService routeService             = new RouteService();
        ReservationService reservationService = new ReservationService();


        Menu menu = new Menu(passengerService, routeService, reservationService);
        menu.showMainMenu();
    }
}
