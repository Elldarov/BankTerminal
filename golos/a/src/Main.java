import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A, B = 0, C = 0, D = 0; 
        int price; 

        A = scanner.nextInt(); 
        if (A >= 1) {
            B = scanner.nextInt(); 
            C = scanner.nextInt(); 
            D = scanner.nextInt(); 
        } else {
            System.out.println("Введите корректное значение");
        }

        

        scanner.close();
    }
}
