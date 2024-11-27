package com.example.functional;
import java.sql.SQLException;
import java.util.Scanner;

import static com.example.functional.Withdrawal.withdraw;
import static com.example.functional.replenishment.replenishmen;

public class functional {
    static Scanner scanner = new Scanner(System.in);
public static void functional() throws SQLException {
    System.out.println("Здраствуйте!\tДля пополнения баланса нажмите 1\tДля вывода средств нажмите 2");
    String num = scanner.next();
    if (num.equals("1") ) {
        replenishmen();
        
    } else if(num.equals("2")){
        withdraw();
    }
}
}
