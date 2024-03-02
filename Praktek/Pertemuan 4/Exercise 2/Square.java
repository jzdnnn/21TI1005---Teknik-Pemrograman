public class Square extends Rectangle{
    private double side;

    public Square(){
        super();
    }

    public Square(double width, double length){
        super(width, length);
        this.side = side;
    }

    @Override
    public String toString(){
        return "A Square with side = " + getWidth() + " which is a subclass of " + super.toString(); 
    }

    @Override
    public void setWidth(){
        super.setWidth();
        super.setLength();
    }

    @Override
    public void setLength(){
        super.setWidth();
        super.setLength();
    }
}