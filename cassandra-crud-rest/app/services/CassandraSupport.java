package services;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.mapping.Mapper;
import models.Album;
import models.SongByAlbum;
import models.SongByArtist;

import javax.inject.Singleton;

@Singleton
public class CassandraSupport {
    private final Cluster cluster;
    private final Session session;

    private final Mapper<Album> albumMapper;
    private final Mapper<SongByAlbum> songByAlbumMapper;
    private final Mapper<SongByArtist> songByArtistMapper;

    public CassandraSupport() {
        cluster = Cluster.builder()
                .addContactPoint("127.0.0.1")
                .withReconnectionPolicy(new ConstantReconnectionPolicy(200))
                .build();

        session = cluster.connect("songbrowser");

        // FixMe: create appropriate mappers
        albumMapper = null;
        songByAlbumMapper = null;
        songByArtistMapper = null;
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

    public void close() {
        cluster.close();
    }
}
