import java.util.Scanner;

public class latihan1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String motorcycleManufacturer, motorcycleType, motorcycleColor, oil;
        int fuel;

        System.out.println("Manufacturers : ");
        motorcycleManufacturer = scanner.nextLine();
        System.out.println();

        System.out.println("Type : ");
        motorcycleType = scanner.nextLine();
        System.out.println();

        System.out.println("Color : ");
        motorcycleColor = scanner.nextLine();
        System.out.println();

        System.out.println("Oil Brand : ");
        oil = scanner.nextLine();
        System.out.println();

        System.out.println("Fuel Quantity (litres) : ");
        fuel = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Motorcycles motorcycle = new Motorcycles(motorcycleManufacturer, motorcycleType, motorcycleColor);
        Engine engine = new Engine(oil, fuel);
        engine.changeOil(motorcycle);
        engine.addFuel(motorcycle);

        scanner.close();
    }
}

class Motorcycles{
    private String motorcycleManufacturer;
    private String motorcycleType;
    private String motorcycleColor;

    public Motorcycles(String motorcycleManufacturer, String motorcycleType, String motorcycleColor){
        this.motorcycleManufacturer = motorcycleManufacturer;
        this.motorcycleType = motorcycleType;
        this.motorcycleColor = motorcycleColor;
    }

    public void engineStart(){
        System.out.println(motorcycleManufacturer + " " + motorcycleType + "'s engine is turned on");
    }

    public void engineStop(){
        System.out.println(motorcycleManufacturer + " " + motorcycleType + "'s engine is turned off");
    }
}

class Engine{
    private String oil;
    private int fuel;

    public Engine(String oil, int fuel){
        this.oil = oil;
        this.fuel = fuel;
    }

    public void changeOil(Motorcycles motorcycle){
        System.out.println("START OIL CHANGING PROCESS");
        motorcycle.engineStop();
        System.out.println("Engine oil was changed to " + oil);
        motorcycle.engineStart();
        System.out.println("OIL CHANGING PROCESS FINISHED");
        System.out.println();
    }

    public void addFuel(Motorcycles motorcycle){
        System.out.println("START REFUELING PROCESS");
        motorcycle.engineStop();
        System.out.println(fuel + " litres of fuel was added to the engine");
        motorcycle.engineStart();
        System.out.println("REFUELING PROCESS FINISHED");
        System.out.println();
    }
}