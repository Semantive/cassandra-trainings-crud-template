package services;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import models.Album;
import models.AlbumAccessor;
import models.SongByAlbum;
import models.SongByArtist;


public class CassandraSupport {
    private final Cluster cluster;
    private final Session session;

    private final Mapper<Album> albumMapper;
    private final Mapper<SongByAlbum> songByAlbumMapper;
    private final Mapper<SongByArtist> songByArtistMapper;
    private final AlbumAccessor albumAccessor;

    public CassandraSupport() {
        final String initialHost = loadEnv("CASSANDRA_HOST", "127.0.0.1");
        final String keyspace = loadEnv("CASSANDRA_KEYSPACE", "songbrowser");

        cluster = Cluster.builder()
                .addContactPoint(initialHost)
                .withReconnectionPolicy(new ConstantReconnectionPolicy(200))
                .build();

        session = cluster.connect(keyspace);
        MappingManager manager = new MappingManager(session);

        albumMapper = manager.mapper(Album.class);
        songByAlbumMapper = manager.mapper(SongByAlbum.class);
        songByArtistMapper = manager.mapper(SongByArtist.class);
        albumAccessor = manager.createAccessor(AlbumAccessor.class);
    }

    public Cluster getCluster() {
        return cluster;
    }

    public Session getSession() {
        return session;
    }

    public Mapper<Album> getAlbumMapper() {
        return albumMapper;
    }

    public Mapper<SongByAlbum> getSongByAlbumMapper() {
        return songByAlbumMapper;
    }

    public Mapper<SongByArtist> getSongByArtistMapper() {
        return songByArtistMapper;
    }

    public AlbumAccessor getAlbumAccessor() {
        return albumAccessor;
    }

    public void close() {
        cluster.close();
    }

    private String loadEnv(final String envName, final String defaultValue) {
        final String valueOrNull = System.getenv(envName);

        if(valueOrNull == null)
            return defaultValue;
        else
            return valueOrNull;
    }
}
