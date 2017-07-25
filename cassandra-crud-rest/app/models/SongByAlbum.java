package models;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

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
}
