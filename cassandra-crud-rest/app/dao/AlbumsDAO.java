package dao;

import com.datastax.driver.mapping.Result;
import models.Album;
import models.Producer;
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
        Producer fakeProducer = new Producer("Ninja", "gb");
        fakeAlbums.add(new Album(artist, 2002, "fake album", "no genre", fakeProducer, "no record label"));

        return fakeAlbums;
    }

    public List<Album> searchAlbumsByTitle(final String pattern) {
        Result<Album> result = cassandraSupport.getAlbumAccessor().searchByTitle( "%" + pattern + "%");

        List<Album> albums = new LinkedList<>();
        for (Album album : result) {
            if (result.getAvailableWithoutFetching() == 100 && !result.isFullyFetched())
                result.fetchMoreResults();
            albums.add(album);
        }
        return albums;
    }


    public void saveAlbum(final Album album) {
        // FixMe
    }
}
