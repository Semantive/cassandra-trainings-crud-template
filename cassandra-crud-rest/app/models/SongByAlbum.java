package models;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.List;

@Table(keyspace = "songbrowser", name = "songs_by_albums")
public class SongByAlbum extends Song {

    @Override
    @PartitionKey
    public String getAlbumTitle() {
        return super.getAlbumTitle();
    }

    @Override
    @PartitionKey
    public Integer getReleaseYear() {
        return super.getReleaseYear();
    }

    public SongByAlbum() {
    }

    public SongByAlbum(String albumTitle, String artist, String genre, List<String> performers, Integer releaseYear, String songTitle, Integer trackNo) {
        super(albumTitle, artist, genre, performers, releaseYear, songTitle, trackNo);
    }
}
