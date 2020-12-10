package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.service.AlbumService;
import com.darksideoftherainbow.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

private final AlbumService albumService;

    public IndexController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/search")
    public String indexFiltered(Model model, @RequestParam("term") String term) {
        List<Album> albums;
        albums = albumService.findAllFilteredAlbums(term);
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/success")
    public String indexWithSuccess(Model model) {
        List<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "Your changes were successfully saved.");
        return "index";
    }

    @GetMapping("/albums/delete/{albumId}")
    public String deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbumById(albumId);
        return "redirect:/";
    }

}
