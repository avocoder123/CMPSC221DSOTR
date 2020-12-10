package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }


    @GetMapping("/album/add")
    public String addAlbumForm() {
        return "addalbum";
    }

    @PostMapping("/album/add")
    private String addAlbumSubmit ( Model model, @RequestParam("albumName") String albumName, @RequestParam("albumArtist") String albumArtist, @RequestParam("albumPrice") String albumPrice, @RequestParam("albumGenre") String Genre, @RequestParam("albumNumberOfTracks") String NumberOfTracks, @RequestParam("albumDate") String Date ) {

        try {
            this.albumService.addAlbum(albumName, albumArtist, albumPrice, Genre, Integer.valueOf(NumberOfTracks), Date);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "addalbum";
        }

        model.addAttribute("success", "Your album was successfully added");
        return "redirect:/success";
    }

    @GetMapping("/albums/edit/{albumId}")
    public String editAlbumPage(@PathVariable int albumId, Model model) {

        Album album = albumService.findAlbumById((long) albumId);

        model.addAttribute("albumId", album.getAlbumId());
        model.addAttribute("albumName", album.getAlbumName());
        model.addAttribute("albumArtist", album.getAlbumArtist());
        model.addAttribute("albumPrice", album.getAlbumPrice());
        model.addAttribute("albumGenre", album.getAlbumGenre());
        model.addAttribute("albumNumberOfTracks", album.getAlbumNumberOfTracks());
        model.addAttribute("albumDate", album.getAlbumDateReleased());

        return "editalbum";
    }

    @PostMapping("/albums/edit")
    public String editAlbumSubmit(@RequestParam Long albumId, @RequestParam String albumName, @RequestParam String albumArtist, @RequestParam String albumPrice, @RequestParam String albumGenre, @RequestParam int albumTracks, @RequestParam String albumDate, Model model) {

        try {
            this.albumService.editAlbum(albumId, albumName, albumArtist, albumPrice, albumGenre, albumTracks, albumDate);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }

        return "redirect:/success";
    }

}
