package models;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.List;

@Table(keyspace = "songbrowser", name = "songs_by_albums")
public class SongByAlbum extends Song {

    @Override
    @PartitionKey(0)
    public Integer getReleaseYear() {
        return super.getReleaseYear();
    }

    @Override
    @PartitionKey(1)
    public String getAlbumTitle() {
        return super.getAlbumTitle();
    }

    @Override
    @ClusteringColumn
    public Integer getTrackNo() {
        return super.getTrackNo();
    }

    public SongByAlbum() {
    }

    public SongByAlbum(String albumTitle, String artist, String genre, List<String> performers, Integer releaseYear, String songTitle, Integer trackNo) {
        super(albumTitle, artist, genre, performers, releaseYear, songTitle, trackNo);
    }
}
