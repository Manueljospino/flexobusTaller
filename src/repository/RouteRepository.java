package repository;

import Entities.Route;
import java.util.ArrayList;

public class RouteRepository {

    private ArrayList<Route> routes = new ArrayList<>();

    public void add(Route route) {
        routes.add(route);
    }

    public Route findByCode(String routeCode) {
        for (Route r : routes) {
            if (r.getRouteCode().equals(routeCode)) return r;
        }
        return null;
    }

    public ArrayList<Route> getAll() {
        return routes;
    }
}

