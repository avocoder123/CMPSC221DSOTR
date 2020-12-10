package com.darksideoftherainbow.model;

import javax.persistence.*;

@Entity

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 100)
    private Long albumId;
    private String albumName,albumArtist;
    private double albumPrice;
    private String albumGenre;
    private int albumNumberOfTracks;
    private String albumDateReleased;

    public Album(){}
    public Album (  String albumName, String albumArtist, double albumPrice, String albumGenre, int albumNumberOfTracks, String albumDateReleased ) {
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.albumPrice = albumPrice;
        this.albumGenre = albumGenre;
        this.albumNumberOfTracks = albumNumberOfTracks;
        this.albumDateReleased = albumDateReleased;
    }

    public Long getAlbumId () {
        return albumId;
    }

    public String getAlbumName () {
        return albumName;
    }
    public void setAlbumId(Long id){
        this.albumId = id;
    }

    public void setAlbumName ( String albumName ) {
        this.albumName = albumName;
    }

    public void setAlbumArtist ( String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public double getAlbumPrice() {
        return albumPrice;
    }

    public  void setAlbumPrice(double albumPrice) {
        this.albumPrice = albumPrice;
    }

    public String getAlbumArtist () {
        return albumArtist;
    }

    public String getAlbumGenre () {
        return albumGenre;
    }

    public int getAlbumNumberOfTracks () {
        return albumNumberOfTracks;
    }
    public String getAlbumDateReleased (){
        return albumDateReleased;
    }


    public void setAlbumDateReleased ( String albumDateReleased ) {
        this.albumDateReleased = albumDateReleased;
    }

    public void setAlbumNumberOfTracks ( int albumNumberOfTracks ) {
        this.albumNumberOfTracks = albumNumberOfTracks;
    }

    public void setAlbumGenre ( String albumGenre ) {
        this.albumGenre = albumGenre;
    }
}
