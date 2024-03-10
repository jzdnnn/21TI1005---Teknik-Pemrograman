/**
 * This is the Supervisor class file extends AbstractStoreEmployee.
 * This class represents a Supervisor of store employee.
 * 
 * @author Jizdan
 */
public class Supervisor extends AbstractStoreEmployee {

    private double supervisionRate;
    /**
     * Constructor for Supervisor.
     *
     * @param numberOfHoursWorked 
     * @param hourlyRate        
     * @param storeDetails       
     * @param basePay            
     * @param employeeName
     */
    public Supervisor(double numberOfHoursWorked, double hourlyRate, String storeDetails,
                          double basePay, String employeeName) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
    }

    public double getSupervisionRate(){
        return supervisionRate * 100;
    }

    public void setSupervisionRate(double supervisionRate){
        this.supervisionRate = supervisionRate;
    }

    /**
     * Calculates pay for the Supervisor.
     *
     * @return - This method returns calculatePay.
     */
    @Override
    public double calculatePay() {
        return super.getNumberOfHoursWorked() * super.getHourlyRate() + super.getBasePay() * (1 + supervisionRate / 100);
    }

    /**
     * Checks if the Supervisor should be awarded with promotion.
     *
     * @return
     */
    @Override
    public boolean checkPromotionEligibility() {
        if (calculatePay() > 37500.0) {
            return true;
        } else {
            return false;
        }
    }
}
