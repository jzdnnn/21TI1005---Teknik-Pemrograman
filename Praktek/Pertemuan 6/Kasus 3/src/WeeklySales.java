import java.util.Scanner;

public class WeeklySales{
    public static void main(String[] args){
        int size, sales;
        String first, last;

        Salesperson[] salesStaff = new Salesperson[10];
        salesStaff[0] = new Salesperson("Jane", "Jones", 3000);
        salesStaff[1] = new Salesperson("Daffy", "Duck", 4935);
        salesStaff[2] = new Salesperson("James", "Jones", 3000);
        salesStaff[3] = new Salesperson("Dick", "Walter", 2800);
        salesStaff[4] = new Salesperson("Don", "Trump", 1570);
        salesStaff[5] = new Salesperson("Jane", "Black", 3000);
        salesStaff[6] = new Salesperson("Harry", "Taylor", 7300);
        salesStaff[7] = new Salesperson("Andy", "Adams", 5000);
        salesStaff[8] = new Salesperson("Jim", "Doe", 2850);
        salesStaff[9] = new Salesperson("Walt", "Smith", 3000);

        Scanner scan = new Scanner(System.in);

        System.out.println("\nHow many salesperson do you want to input?" );
        size = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < size; i++){
            System.out.println("Masukkan nama awal: ");
            first = scan.nextLine();
            System.out.println("Masukkan nama akhir: ");
            last = scan.nextLine();
            System.out.println("Masukkan nilai penjualan: ");
            sales = scan.nextInt();
            scan.nextLine();

            salesStaff[i] = new Salesperson(first, last, sales);
        }

        /*
        for (int i = size; i < salesStaff.length; i++) {
            salesStaff[i] = new Salesperson("", "", 0);
        }
        */
        

        Sorting.insertionSort(salesStaff);
        System.out.println("\nRanking of sales for the Week\n");
        for(Salesperson s : salesStaff){
            System.out.println(s);
        }
    }
}