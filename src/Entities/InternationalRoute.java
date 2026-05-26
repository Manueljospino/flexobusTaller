package Entities;

public class InternationalRoute extends Route {

    private String destinationCountry;
    private boolean requiresPassport;
    private double internationalFee;

    public InternationalRoute(String routeCode, String originCity, String destinationCity,
                              String departureDate, String departureTime, String arrivalTime,
                              int totalSeats, double basePrice,
                              String destinationCountry, boolean requiresPassport,
                              double internationalFee) {
        super(routeCode, originCity, destinationCity, departureDate,
                departureTime, arrivalTime, totalSeats, basePrice);
        this.destinationCountry = destinationCountry;
        this.requiresPassport = requiresPassport;
        this.internationalFee = internationalFee;
    }


    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public boolean isRequiresPassport() {
        return requiresPassport;
    }

    public void setRequiresPassport(boolean requiresPassport) {
        this.requiresPassport = requiresPassport;
    }

    public double getInternationalFee() {
        return internationalFee;
    }

    public void setInternationalFee(double internationalFee) {
        this.internationalFee = internationalFee;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + internationalFee;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nType        : International" +
                "\nCountry     : " + destinationCountry +
                "\nPassport    : " + (requiresPassport ? "Required" : "Not Required") +
                "\nIntl. Fee   : $" + internationalFee;
    }
}
