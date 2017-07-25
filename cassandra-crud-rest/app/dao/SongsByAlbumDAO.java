package dao;

import models.Song;
import models.SongByAlbum;
import services.CassandraSupport;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class SongsByAlbumDAO {

    private CassandraSupport cassandraSupport;

    @Inject
    public SongsByAlbumDAO(CassandraSupport cassandraSupport) {
        this.cassandraSupport = cassandraSupport;
    }

    public List<Song> getSongs(final Integer releaseYear, final String albumTitle) {
        // FixMe
        List<Song> fakeSongs = new LinkedList<>();
        fakeSongs.add(new SongByAlbum(albumTitle, "no artist", "no genre", new LinkedList<>(), releaseYear, "no song title", 0));

        return fakeSongs;
    }

    public void saveSong(final SongByAlbum song) {
        // FixMe
    }
}
