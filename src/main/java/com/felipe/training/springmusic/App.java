package com.felipe.training.springmusic;

import java.io.PrintStream;
import java.util.Scanner;

public class App {

    private static final PrintStream printer = System.out;
    private static final Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        var option = selectOption();
        switchByOption(option);
    }
    private int selectOption() {
        var menu  = """
                ***Spring Music App***
                
                1 - Register Artists.
                
                0 - Leave.
                """;
        printer.println(menu);
        return scanner.nextInt();
    }
    private void switchByOption(int option) {
        switch (option) {
            case 1:
                registerArtist();
                break;
            case 2:
                leave();
                break;
            default:
                printer.println("Invalid option!!");
        }
    }
    private void registerArtist() {
        //register artist
    }
    private void leave() {
        //leave
    }
}
