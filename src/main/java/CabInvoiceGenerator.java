import java.util.ArrayList;

public class CabInvoiceGenerator {
    //TO CONSTANTS
    private double COST_PER_KILOMETER;
    private int COST_PER_MINUTE;
    private int MINIMUM_FARE;

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
        public double getTotalFare ( double distanceInKiloMeter, int travelPerMinute, RideType type){
            setValue(type);
            totalFare = distanceInKiloMeter * COST_PER_KILOMETER + travelPerMinute * COST_PER_MINUTE;
            return Math.max(MINIMUM_FARE, totalFare);

        }

        //TO METHOD TO GET INVOICE DETAILS
        public InvoiceDetails getInvoiceDetails (String userId){
            ArrayList userRides = rideRepository.getRideDetails(userId);
            Ride[] rides = new Ride[userRides.size()];
            userRides.toArray(rides);
            for (Ride ride : rides) {
                totalFare += this.getTotalFare(ride.distanceInKiloMeter, ride.travelPerMinute, ride.type);
            }
            return new InvoiceDetails(rides.length, totalFare);

        }

        //TO SET VALUE
        private void setValue (RideType type){
            this.COST_PER_KILOMETER = type.costPerKilometer;
            this.COST_PER_MINUTE = type.timePerMinute;
            this.MINIMUM_FARE = type.minimumFare;
        }
        public void addRides (String userId, Ride[]rides){
            rideRepository.addRide(userId, rides);
        }
    }