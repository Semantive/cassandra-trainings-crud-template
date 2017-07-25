package dao;

import models.Song;
import models.SongByAlbum;
import models.SongByArtist;
import services.CassandraSupport;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class SongsByArtistDAO {

    private CassandraSupport cassandraSupport;

    @Inject
    public SongsByArtistDAO(CassandraSupport cassandraSupport) {
        this.cassandraSupport = cassandraSupport;
    }

    public List<Song> getSongs(final String artist) {
        // FixMe
        List<Song> fakeSongs = new LinkedList<>();
        fakeSongs.add(new SongByAlbum("no album", artist, "no genre", new LinkedList<>(), 2002, "no song title", 0));

        return fakeSongs;
    }

    public void saveSong(final SongByArtist song) {
        // FixMe
    }
}
