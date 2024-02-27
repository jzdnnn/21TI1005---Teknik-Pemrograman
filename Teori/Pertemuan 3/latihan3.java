// Pertemuan 3 (Teori) Generalization and Specialization 2024
// Author   : Jizdan Mulkan Nailan - 231524011
// Date     : 20/02/2024

public class latihan3{
    public static void main(String[] args){
        Coffee Robusta = new Robusta();
        Coffee Arabica = new Arabica();
        Corn sweetCorn = new sweetCorn();
        Corn yellowCorn = new yellowCorn();

        Arabica.roast();
        Robusta.roast();

        yellowCorn.mill();
        sweetCorn.mill();
    }
}

abstract class agriculturalPlants{
    abstract void harvest();
}

abstract class Coffee extends agriculturalPlants{
    abstract void roast();
    void harvest(){
        System.out.println("Coffee was harvested");
    }
}

class Robusta extends Coffee{
    void roast(){
        System.out.println("Robusta Coffee was roasted");
    }
}

class Arabica extends Coffee{
    void roast(){
        System.out.println("Arabica Coffee was roasted");
    }
}

abstract class Corn extends agriculturalPlants{
    abstract void mill();
    void harvest(){
        System.out.println("Corn was harvested");
    }
}

class sweetCorn extends Corn{
    void mill(){
        System.out.println("Sweet Corn was milled");
    }
}

class yellowCorn extends Corn{
    void mill(){
        System.out.println("Yellow Corn was milled");
    }
}