package com.darksideoftherainbow.repository;

import com.darksideoftherainbow.model.Album;

import java.util.List;

public interface AlbumRepository {
    List<Album> getAlbums();

    Album addAlbum(Album album);

    Album findAlbumById(Long albumId);

    Album editAlbum(Long albumId, String albumName, String albumArtist, double albumPrice, String albumGenre, int albumNumberOfTracks, String DateReleased);

    boolean deleteAlbumId(Long albumId);

}
