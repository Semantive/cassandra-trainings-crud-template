package models;

import com.datastax.driver.mapping.annotations.Column;

import java.util.List;

public class Song {
    private String albumTitle;
    private String artist;
    private String genre;
    private List<String> performers;
    private Integer releaseYear;
    private String songTitle;
    private Integer trackNo;

    public Song() {
    }

    public Song(String albumTitle, String artist, String genre, List<String> performers, Integer releaseYear, String songTitle, Integer trackNo) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.genre = genre;
        this.performers = performers;
        this.releaseYear = releaseYear;
        this.songTitle = songTitle;
        this.trackNo = trackNo;
    }

    @Column(name = "album_title")
    public String getAlbumTitle() {
        return albumTitle;
    }

    public Song setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
        return this;
    }

    @Column(name = "artist")
    public String getArtist() {
        return artist;
    }

    public Song setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public Song setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    @Column(name = "performers")
    public List<String> getPerformers() {
        return performers;
    }

    public Song setPerformers(List<String> performers) {
        this.performers = performers;
        return this;
    }

    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Song setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    @Column(name = "song_title")
    public String getSongTitle() {
        return songTitle;
    }

    public Song setSongTitle(String songTitle) {
        this.songTitle = songTitle;
        return this;
    }

    @Column(name = "track_no")
    public Integer getTrackNo() {
        return trackNo;
    }

    public Song setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
        return this;
    }
}