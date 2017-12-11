package dao;

import org.junit.Before;
import org.junit.Test;
import services.CassandraSupport;

public class SongsByArtistDAOTest extends AbstractDAOTest {

    private CassandraSupport cassandraSupport = null;
    private SongsByArtistDAO songsByArtistDAO = null;

    @Before
    public void prepateCassandra() {
        setupCassandra();

        cassandraSupport = new CassandraSupport();
        songsByArtistDAO = new SongsByArtistDAO(cassandraSupport);
    }

    @Test
    public void getSongsByArtistTest() {
        // FixMe: test songs that exists in the db
        // FixMe: test songs that do not exist in the db
    }

    @Test
    public void saveAlbumTest() {
        // FixMe: save song in the database

        // FixMe: retrieve it

        // FixMe: compare it with saved one
    }
}
