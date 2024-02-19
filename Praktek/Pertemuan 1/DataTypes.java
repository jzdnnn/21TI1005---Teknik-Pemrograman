import java.util.Scanner;

public class DataTypes
{
    public static void main(String[] args) {
        int numberInput;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan jumlah angka yang akan diinput : ");
        numberInput = scanner.nextInt();

        System.out.println("Masukkan angka yang akan dicek : ");
        String[] input = new String[numberInput];

        
        for (int i = 0; i < numberInput; i++) {
            input[i] = scanner.next();
        }
        
        for (int i = 0; i < numberInput; i++){
            check(input[i]);
        }
        scanner.close();
    }

    static void check(String input){
        try{
            long nilai = Long.parseLong(input);
            System.out.println(nilai + " can be fitted in : ");

            if(nilai >= Byte.MIN_VALUE && nilai <= Byte.MAX_VALUE){
                System.out.println("* byte");
            }
            if(nilai >= Short.MIN_VALUE && nilai <= Short.MAX_VALUE){
                System.out.println("* short");
            }
            if(nilai >= Integer.MIN_VALUE && nilai <= Integer.MAX_VALUE){
                System.out.println("* int");
            }
            System.out.println("* long");
        } catch(NumberFormatException e){
            System.out.println(input + " can't be fitted anywhere");
        }
    }
}
