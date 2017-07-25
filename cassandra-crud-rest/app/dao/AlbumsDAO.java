package dao;

import models.Album;
import services.CassandraSupport;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AlbumsDAO {

    private CassandraSupport cassandraSupport;

    @Inject
    public AlbumsDAO(CassandraSupport cassandraSupport) {
        this.cassandraSupport = cassandraSupport;
    }

    public List<Album> getAlbums(final String artist) {
        // FixMe
        List<Album> fakeAlbums = new LinkedList<>();
        fakeAlbums.add(new Album(artist, 2002, "fake album", "no genre", "no producer", "no record label"));

        return fakeAlbums;
    }

    public void saveAlbum(final Album album) {
        // FixMe
    }
}
