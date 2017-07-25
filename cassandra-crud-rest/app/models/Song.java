package models;

import com.datastax.driver.mapping.annotations.Column;

import java.util.List;

abstract public class Song {

    @Column(name = "album_title")
    private String albumTitle;

    @Column(name = "artist")
    private String artist;

    @Column(name = "genre")
    private String genre;

    @Column(name = "performers")
    private List<String> performers;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "song_title")
    private String songTitle;

    @Column(name = "track_no")
    private Integer trackNo;


    public String getAlbumTitle() {
        return albumTitle;
    }

    public Song setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public Song setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Song setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public List<String> getPerformers() {
        return performers;
    }

    public Song setPerformers(List<String> performers) {
        this.performers = performers;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Song setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public Song setSongTitle(String songTitle) {
        this.songTitle = songTitle;
        return this;
    }

    public Integer getTrackNo() {
        return trackNo;
    }

    public Song setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
        return this;
    }
}