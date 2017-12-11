package dao;

import org.junit.Before;
import org.junit.Test;
import services.CassandraSupport;

public class SongsByAlbumDAOTest extends AbstractDAOTest {

    private CassandraSupport cassandraSupport = null;
    private SongsByAlbumDAO songsByAlbumDAO = null;

    @Before
    public void prepateCassandra() {
        setupCassandra();

        cassandraSupport = new CassandraSupport();
        songsByAlbumDAO = new SongsByAlbumDAO(cassandraSupport);
    }

    @Test
    public void getSongsByAlbumTest() {
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
