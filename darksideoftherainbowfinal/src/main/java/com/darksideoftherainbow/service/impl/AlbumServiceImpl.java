package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.repository.AlbumRepository;
import com.darksideoftherainbow.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    public AlbumServiceImpl(AlbumRepository albumRepository ) {
       this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAlbums() {
        return albumRepository.getAlbums();
    }

    @Override
    public Album addAlbum(String albumName, String albumArtist, String albumPrice, String albumGenre, int albumTracks, String albumDate ) {
        if (albumName == null || albumName.isEmpty()) {
            throw new IllegalArgumentException("album name cannot be null");
        }
        Double price;
        try {
            price = Double.valueOf(albumPrice);
        } catch (NumberFormatException nfex) {
            throw new IllegalArgumentException("invalid album price");
        }
        Album album = new Album(albumName,albumArtist,price,albumGenre,albumTracks,albumDate);
        return albumRepository.addAlbum(album);
    }

    @Override
    public List<Album> findAllFilteredAlbums(String filter) {

        List<Album> allAlbums = albumRepository.getAlbums();
        return allAlbums.stream()
                .filter(g -> g.getAlbumName().toLowerCase().contains(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Album findAlbumById(Long albumId) {
        return albumRepository.findAlbumById((long) albumId);
    }

    @Override
    public Album editAlbum ( Long albumId, String albumName, String albumArtist, String albumPrice,String genre, int albumNumberOfTracks, String albumDateReleased ) {
        double price;
        try{
            price = Double.parseDouble(albumPrice);
        }catch(Exception e){
            price = 0.00;
        }
        return albumRepository.editAlbum(albumId, albumName, albumArtist, price, genre,albumNumberOfTracks, albumDateReleased);
    }

    @Override
    public boolean deleteAlbumById( Long albumId) {
        return albumRepository.deleteAlbumId(albumId);
    }
}
