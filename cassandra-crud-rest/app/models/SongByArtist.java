package models;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "songbrowser", name = "songs_by_artists")
public class SongByArtist extends Song {

    @Override
    @PartitionKey
    public String getArtist() {
        return super.getArtist();
    }
}
