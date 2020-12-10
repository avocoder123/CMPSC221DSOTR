package com.darksideoftherainbow.service;

        import com.darksideoftherainbow.model.Album;

        import java.util.List;

public interface AlbumService {
    List<Album> getAlbums();

    Album addAlbum ( String albumName, String albumArtist, String albumPrice, String albumGenre, int albumTracks, String albumDate );

    List<Album> findAllFilteredAlbums(String filter);

    Album findAlbumById(Long albumId);

    Album editAlbum ( Long albumId, String albumName, String albumArtist, String albumPrice, String albumGenre, int albumTracks, String albumDate );

    boolean deleteAlbumById ( Long albumId );
}
