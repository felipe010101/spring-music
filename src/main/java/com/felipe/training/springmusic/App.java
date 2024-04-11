package com.felipe.training.springmusic;

import java.io.PrintStream;
import java.util.Scanner;

public class App {

    private static final PrintStream printer = System.out;
    private static final Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        var showMenu = true;
        while (showMenu) {
            var option = selectOption();
            showMenu = switchByOption(option);
        }
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
    private boolean switchByOption(int option) {
        switch (option) {
            case 1:
                registerArtist();
                break;
            case 0:
                return leave();
            default:
                printer.println("Invalid option!!");
        }
        return true;
    }
    private void registerArtist() {
        //register artist
    }
    private boolean leave() {
        printer.println("leaving....");
        return false;
    }
}
