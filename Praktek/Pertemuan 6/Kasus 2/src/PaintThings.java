import java.text.DecimalFormat;

public class PaintThings{
    //Create some shapes and a Paint object and prints the amount of paint needed to paint each shape
    public static void main(String[] args){
        final double COVERAGE = 350;
        Paint paint = new Paint (COVERAGE);

        // Instantiate the three shapes to paint
        Shape deck = new Rectangle("Deck", 20, 35);
        Shape bigBall = new Sphere("Big Ball", 15);
        Shape tank = new Cylinder("Tank", 10, 30);

        // Compute the amount of paint needed for each shape
        double deckAmt = new Paint(COVERAGE).amount(deck);
        double ballAmt = new Paint(COVERAGE).amount(bigBall);
        double tankAmt = new Paint(COVERAGE).amount(tank);

        // Print the amount of paint for each
        DecimalFormat fmt = new DecimalFormat("0.#");
        System.out.println("\nNumber of gallons of paint needed...");
        System.out.println("Deck " + fmt.format(deckAmt));
        System.out.println("Big Ball " + fmt.format(ballAmt));
        System.out.println("Tank " + fmt.format(tankAmt));
    }
}