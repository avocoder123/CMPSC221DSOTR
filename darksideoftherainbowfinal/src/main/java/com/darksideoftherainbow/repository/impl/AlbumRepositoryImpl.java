package com.darksideoftherainbow.repository.impl;

import com.darksideoftherainbow.jpa.JpaAlbumRepository;
import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.repository.AlbumRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    private final JpaAlbumRepository jpaAlbumRepository;

    public AlbumRepositoryImpl(JpaAlbumRepository jpaAlbumRepository) {
        this.jpaAlbumRepository = jpaAlbumRepository;
    }

    @Override
    public List<Album> getAlbums() {
        return (List<Album>) jpaAlbumRepository.findAll();
    }

    @Override
    public Album addAlbum(Album album) {
        return jpaAlbumRepository.save(album);
    }
    @Override
    public Album findAlbumById(Long albumId) {
        Optional<Album> album = jpaAlbumRepository.findById(albumId);
        if (album.isPresent()) {
            return album.get();
        }
        throw new IllegalStateException("Album with ID " + albumId + " is not found!");
    }
    @Override
    public Album editAlbum(Long albumId, String albumName, String albumArtist, double albumPrice,String genre,int tracks,String date) {

        Album existing = findAlbumById(albumId);
        existing.setAlbumId(albumId);
        existing.setAlbumName(albumName);
        existing.setAlbumGenre(genre);
        existing.setAlbumDateReleased(date);
        existing.setAlbumNumberOfTracks(tracks);
        existing.setAlbumArtist(albumArtist);
        existing.setAlbumPrice(albumPrice);
        return jpaAlbumRepository.save(existing);
    }

    @Override
    public boolean deleteAlbumId(Long albumId) {
        jpaAlbumRepository.deleteById(albumId);
        return true;
    }
    }