package com.example;

import java.sql.SQLException;
import java.util.Scanner;

import static com.example.functional.added.registration;
import static com.example.functional.entry.entry;

public class main {
public static void main(String[] args) throws SQLException {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Если у вас уже есть аккаунт,напишите 1,если желаете зарегестрироваться,2");
    if (scanner.next().equals("2")) {
    registration();
        
    }
    else{
        entry();

    }
    


}

}
