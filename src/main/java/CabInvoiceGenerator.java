import java.util.ArrayList;

public class CabInvoiceGenerator {
    //TO CONSTANTS
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    //VARIABLE
    double totalFare = 0;

    RideRepository rideRepository = null;

    CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }

    //TO METHOD TO GET TOTAL FARE FOR JOURNEY
    public double getTotalFare(Ride[] rides) {
        for (Ride ride : rides) {
            totalFare = ride.distanceInKiloMeter * COST_PER_KILOMETER + ride.travelPerMinute * COST_PER_MINUTE;
        }
        return Math.max(MINIMUM_FARE, totalFare);
    }

    //TO METHOD TO GET INVOICE DETAILS
    public InvoiceDetails getInvoiceDetails(String userId) {
        ArrayList userRides = rideRepository.getRideDetails(userId);
        Ride[] rides = new Ride[userRides.size()];
        userRides.toArray(rides);
        double totalFare = getTotalFare(rides);
        return new InvoiceDetails(rides.length, totalFare);

    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }
}