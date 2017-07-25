package models;

import java.util.List;

public class SongsPage {
    private List<Song> songs;
    private String page;

    public SongsPage(List<Song> songs, String page) {
        this.songs = songs;
        this.page = page;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
