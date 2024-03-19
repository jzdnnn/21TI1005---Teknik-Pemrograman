public class Cylinder extends Shape{
    private double radius;
    private double height;

    public Cylinder(String shapeName, double r, double h){
        super(shapeName);
        radius = r;
        height = h;
    }

    public double area(){
        return Math.PI * radius * radius * height;
    }

    public String toString(){
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}