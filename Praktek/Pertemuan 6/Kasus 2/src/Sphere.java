public class Sphere extends Shape{
    private double radius;

    // Constructor
    public Sphere(String shapeName, double r){
        super(shapeName);
        radius = r;
    }

    // Returns the surface area of the sphere
    public double area(){
        return 4 * Math.PI * radius * radius;
    }

    // Returns the sphere as a String
    public String toString(){
        return super.toString() + " of radius " + radius;
    }
}