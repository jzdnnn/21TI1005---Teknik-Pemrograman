public class Paint{
    private double coverage;

    // Constructor
    public Paint(double coverage){
        this.coverage = coverage;
    }

    // Returns the amount of paint (number of gallons needed to paint the shape given as the parameter)
    public double amount(Shape shape){
        double area = shape.area();
        System.out.println("Computing amount for " + shape);
        return area / coverage;
    }
}