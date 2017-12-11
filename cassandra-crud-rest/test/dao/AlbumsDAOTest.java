package dao;

import models.Album;
import models.Producer;
import org.cassandraunit.CassandraCQLUnit;
import org.junit.Before;
import org.junit.Test;
import services.CassandraSupport;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlbumsDAOTest extends AbstractDAOTest {

    private CassandraSupport cassandraSupport = null;
    private AlbumsDAO albumsDAO = null;

    @Before
    public void prepateCassandra() {
        setupCassandra();

        cassandraSupport = new CassandraSupport();
        albumsDAO = new AlbumsDAO(cassandraSupport);
    }

    @Test
    public void getAlbumsTest() {
        final List<Album> soadAlbums = albumsDAO.getAlbums("System of a Down");
        assertEquals(2, soadAlbums.size());

        final List<Album> rhcpAlbums = albumsDAO.getAlbums("Red Hot Chili Peppers");
        assertEquals(1, rhcpAlbums.size());

        final List<Album> zmAlbums = albumsDAO.getAlbums("Zenon Martyniuk");
        assertEquals(0, zmAlbums.size());
    }

    @Test
    public void saveAlbumTest() {
        final Producer producer = new Producer("BIEM", "PL");
        final Album album = new Album("Violetta Villas", 1968, "Dla ciebie miły", "Folk", producer, "Polskie Nagrania Muza");
        albumsDAO.saveAlbum(album);

        final List<Album> loadedAlbums = albumsDAO.getAlbums(album.getArtist());
        assertEquals(1, loadedAlbums.size());
        assertEquals(loadedAlbums.get(0).getAlbumTitle(), album.getAlbumTitle());
    }
}
