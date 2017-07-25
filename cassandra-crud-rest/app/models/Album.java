package models;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "songbrowser", name = "albums")
public class Album {

    @PartitionKey
    @Column(name = "artist")
    private String artist;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "album_title")
    private String albumTitle;

    @Column(name = "genre")
    private String genre;

    @Column(name = "producer")
    private String producer;

    @Column(name = "record_label")
    private String recordLabel;

    public Album(String artist, Integer releaseYear, String albumTitle, String genre, String producer, String recordLabel) {
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.producer = producer;
        this.recordLabel = recordLabel;
    }

    public String getArtist() {
        return artist;
    }

    public Album setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Album setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public Album setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Album setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public Album setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
        return this;
    }
}
