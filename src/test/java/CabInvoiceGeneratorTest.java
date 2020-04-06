import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    //TO CREATE OBJECT OF MAIN CLASS
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

    //TEST CASE 1.1
    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnTotalFareForJourney() {
        double totalFare = cabInvoiceGenerator.getTotalFare(20, 20);
        Assert.assertEquals(220, totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnMinimumFareForJourney() {
        int time = 3;
        double distance = 0.1;
        double totalFare = cabInvoiceGenerator.getTotalFare(distance, time);
        Assert.assertEquals(5, totalFare, 0);
    }
}
