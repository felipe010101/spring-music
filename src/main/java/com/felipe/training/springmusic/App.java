package com.felipe.training.springmusic;

import com.felipe.training.springmusic.dto.ArtistDTO;
import com.felipe.training.springmusic.dto.MusicDTO;
import com.felipe.training.springmusic.model.Artist;
import com.felipe.training.springmusic.model.ArtistType;
import com.felipe.training.springmusic.model.Music;
import com.felipe.training.springmusic.repository.ArtistRepository;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    private static final PrintStream printer = System.out;
    private static final Scanner scanner = new Scanner(System.in);
    private final ArtistRepository repository;

    public App(ArtistRepository repository) {this.repository = repository;}

    public void startMenu() {
        var showMenu = true;
        while(showMenu) {
            showMenu = switchByOption(selectOption());
        }
    }
    private int selectOption() {
        var menu  = """
                ***Spring Music App***
                
                1 - Register an Artist.
                2 - Register a Music.
                3 - List all artists;
                
                0 - Leave.
                """;
        printer.println(menu);
        var option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
    private boolean switchByOption(int option) {
        switch (option) {
            case 1:
                registerArtist();
                break;
            case 2:
                registerMusic();
                break;
            case 3:
                listArtists();
                break;
            case 0:
                return leave();
            default:
                printer.println("Invalid option!!");
        }
        return true;
    }
    private void registerArtist() {
        printer.println("Insert the artist name:");
        var name = scanner.nextLine();
        printer.println("Choose the Artist Type: \n" +
                "Solo, Pair or Band");
        var type = scanner.nextLine();
        Artist artist = new Artist();
        artist.setName(name);
        artist.setType(ArtistType.valueOf(type.toUpperCase()));
        repository.save(artist);
    }
    private void registerMusic() {
        printer.println("Register music from what artist?");
        var artistName = scanner.nextLine();
        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(artistName);
        if (artist.isPresent()) {
            Artist foundedArtist = artist.get();
            printer.println("Insert the music name:");
            var musicName = scanner.nextLine();
            Music music = new Music();
            music.setTitle(musicName);
            music.setArtist(foundedArtist);
            List<Music> musicList = foundedArtist.getMusics();
            musicList.add(music);
            foundedArtist.setMusics(musicList);
            repository.save(foundedArtist);
        } else {
            printer.println("Artist not founded on database, try to register first ;)");
        }
    }
    private void listArtists() {
        List<Artist> artistList = repository.findAll();
        List<MusicDTO> musicDTOS = artistList.stream()
                .flatMap(artist -> artist.getMusics()
                        .stream()
                        .map(music -> new MusicDTO(music.getId(), music.getTitle()))).toList();
        List<ArtistDTO> artistDTOS = artistList.stream()
                        .map(artist -> new ArtistDTO(artist.getId(),artist.getName(),artist.getType(), musicDTOS))
                                .toList();
        artistDTOS.forEach(printer::println);
    }
    private boolean leave() {
        printer.println("leaving....");
        return false;
    }
}
