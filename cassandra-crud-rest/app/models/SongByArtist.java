package models;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.List;

@Table(keyspace = "songbrowser", name = "songs_by_artists")
public class SongByArtist extends Song {

    @Override
    @PartitionKey
    public String getArtist() {
        return super.getArtist();
    }

    public SongByArtist() {
    }

    public SongByArtist(String albumTitle, String artist, String genre, List<String> performers, Integer releaseYear, String songTitle, Integer trackNo) {
        super(albumTitle, artist, genre, performers, releaseYear, songTitle, trackNo);
    }
}
