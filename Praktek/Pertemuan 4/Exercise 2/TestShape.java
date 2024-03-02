public class TestShape{
    public static void main(String[] args){
        Shape shape = new Shape();
        System.out.println("Shape:  Color = " + shape.getColor() + " Filled = " + shape.getFilled());
        System.out.println(shape.toString());
    }
}