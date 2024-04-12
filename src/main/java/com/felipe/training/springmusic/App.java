package com.felipe.training.springmusic;

import com.felipe.training.springmusic.model.Artist;
import com.felipe.training.springmusic.repository.ArtistRepository;

import java.io.PrintStream;
import java.security.PublicKey;
import java.util.Scanner;

public class App {

    private static final PrintStream printer = System.out;
    private static final Scanner scanner = new Scanner(System.in);
    private final ArtistRepository repository;

    public App(ArtistRepository repository) {this.repository = repository;}

    public void startMenu() {
        switchByOption(selectOption());
    }
    private int selectOption() {
        var menu  = """
                ***Spring Music App***
                
                1 - Register Artists.
                
                0 - Leave.
                """;
        printer.println(menu);
        var option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
    private void switchByOption(int option) {
        switch (option) {
            case 1:
                registerArtist();
                break;
            case 0:
                leave();
                break;
            default:
                printer.println("Invalid option!!");
        }
    }
    private void registerArtist() {
        printer.println("Insert the artist name:");
        var name = scanner.nextLine();
        Artist artist = new Artist(name);
        repository.save(artist);
    }
    private void leave() {
        printer.println("leaving....");
    }
}
