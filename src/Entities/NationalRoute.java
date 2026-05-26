package Entities;

public class NationalRoute extends Route {

    private double estimatedDurationHours;
    private boolean hasRestStops;

    public NationalRoute(String routeCode, String originCity, String destinationCity,
                         String departureDate, String departureTime, String arrivalTime,
                         int totalSeats, double basePrice,
                         double estimatedDurationHours, boolean hasRestStops) {
        super(routeCode, originCity, destinationCity, departureDate,
                departureTime, arrivalTime, totalSeats, basePrice);
        this.estimatedDurationHours = estimatedDurationHours;
        this.hasRestStops = hasRestStops;
    }


    public double getEstimatedDurationHours() {
        return estimatedDurationHours;
    }

    public void setEstimatedDurationHours(double estimatedDurationHours) {
        this.estimatedDurationHours = estimatedDurationHours;
    }

    public boolean isHasRestStops() {
        return hasRestStops;
    }

    public void setHasRestStops(boolean hasRestStops) {
        this.hasRestStops = hasRestStops;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice(); // sin cargos adicionales
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nType        : Domestic" +
                "\nDuration    : " + estimatedDurationHours + " hours" +
                "\nRest Stops  : " + (hasRestStops ? "Yes" : "No");
    }
}
