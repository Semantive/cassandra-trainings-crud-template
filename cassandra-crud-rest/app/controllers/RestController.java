package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dao.AlbumsDAO;
import dao.SongsByAlbumDAO;
import dao.SongsByArtistDAO;
import models.Album;
import models.Song;
import models.SongByAlbum;
import models.SongByArtist;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class RestController extends Controller {

    final private AlbumsDAO albumsDAO;
    final private SongsByAlbumDAO songsByAlbumDAO;
    final private SongsByArtistDAO songsByArtistDAO;

    @Inject
    public RestController(AlbumsDAO albumsDAO, SongsByAlbumDAO songsByAlbumDAO, SongsByArtistDAO songsByArtistDAO) {
        this.albumsDAO = albumsDAO;
        this.songsByAlbumDAO = songsByAlbumDAO;
        this.songsByArtistDAO = songsByArtistDAO;
    }

    public Result getAlbumsByArtist(final String artist) {
        final List<Album> albums = albumsDAO.getAlbums(artist);
        final JsonNode albumsAsJson = Json.toJson(albums);
        return ok(albumsAsJson);
    }

    public Result getSongsByArtist(final String artist) {
        final List<Song> songs = songsByArtistDAO.getSongs(artist);
        final JsonNode songsAsJson = Json.toJson(songs);
        return ok(songsAsJson);
    }

    public Result getSongsByAlbum(final Integer releaseYear, final String albumTitle) {
        final List<Song> songs = songsByAlbumDAO.getSongs(releaseYear, albumTitle);
        final JsonNode songsAsJson = Json.toJson(songs);
        return ok(songsAsJson);
    }


    public Result saveAlbum() {
        final JsonNode albumJson = request().body().asJson();

        final Album album = Json.fromJson(albumJson, Album.class);
        albumsDAO.saveAlbum(album);

        return ok("OK");
    }

    public Result saveSong() {
        final JsonNode songJson = request().body().asJson();

        final SongByArtist songByArtist = Json.fromJson(songJson, SongByArtist.class);
        songsByArtistDAO.saveSong(songByArtist);

        final SongByAlbum songByAlbum = Json.fromJson(songJson, SongByAlbum.class);
        songsByAlbumDAO.saveSong(songByAlbum);

        return ok("OK");
    }
}
