import java.util.Scanner;

public class strings{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String A, B;
        System.out.println("Masukkan kata :");
        A = scanner.nextLine();
        B = scanner.nextLine();

        int length = A.length() + B.length();
        String kata1, kata2;

        String compare = (A.compareTo(B) > 0)? "Yes" : "No";

        String kapitalA = A.substring(0, 1).toUpperCase();
        kata1 = kapitalA + A.substring(1);

        String kapitalB = B.substring(0, 1).toUpperCase();
        kata2 = kapitalB + B.substring(1);

        System.out.println();
        System.out.println("Output : ");
        System.out.println(length);
        System.out.println(compare);
        System.out.println(kata1 + " " + kata2);
    }
}