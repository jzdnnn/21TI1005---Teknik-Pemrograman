public class Commission extends Hourly{
    private double totalSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double comRate){
        super(eName, eAddress, ePhone, socSecNumber, rate);
        commissionRate = comRate;
    }

    public void addSales(double totalSales){
        this.totalSales += totalSales;
    }

    public double pay(){
        double pay = super.pay();
        pay += totalSales * commissionRate;
        this.totalSales = 0;
        return pay;
    }

    public String toString(){
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}