package dao;

import com.datastax.driver.core.PagingState;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.Result;
import models.Song;
import models.SongByAlbum;
import models.SongByArtist;
import models.SongsPage;
import services.CassandraSupport;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class SongsByArtistDAO {

    private CassandraSupport cassandraSupport;
    private static final Integer paginateSongsPageSize = 2;

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

    public SongsPage paginateSongs(final String artist, final String requestedPage) {
        Statement st = new SimpleStatement("SELECT * FROM songs_by_artists WHERE artist = ?", artist);
        st.setFetchSize(paginateSongsPageSize);

        if (requestedPage != null && !requestedPage.isEmpty()) {
            st.setPagingState(PagingState.fromString(requestedPage));
        }

        ResultSet rs = cassandraSupport.getSession().execute(st);
        PagingState nextPage = rs.getExecutionInfo().getPagingState();

        List<Song> songs = new LinkedList<>();
        Mapper<SongByArtist> mapper = cassandraSupport.getSongByArtistMapper();

        // Note that we don't rely on RESULTS_PER_PAGE, since Cassandra might
        // have not respected it, or we might be at the end of the result set
        Result<SongByArtist> r = mapper.map(rs);
        int remaining = r.getAvailableWithoutFetching();
        for (SongByArtist s : r) {
            songs.add(s);
            if (--remaining == 0) {
                break;
            }
        }

        String nexPageS = null;
        if (nextPage != null) {
            nexPageS = nextPage.toString();
        }

        return new SongsPage(songs, nexPageS);
    }

}
