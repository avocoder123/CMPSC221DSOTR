package com.darksideoftherainbow.controller.api;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final AlbumService albumService;

    public ApiController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/api/get-album")
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }
}
