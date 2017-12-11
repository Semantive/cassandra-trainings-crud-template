CREATE KEYSPACE IF NOT EXISTS songbrowser WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

CREATE TYPE IF NOT EXISTS songbrowser.producer (
  name          TEXT,
  country_code  TEXT
);

CREATE TABLE IF NOT EXISTS songbrowser.albums (
  album_title    VARCHAR,
  artist         VARCHAR,
  genre          VARCHAR,
  producer       producer,
  record_label   VARCHAR,
  release_year   INT,
  PRIMARY KEY ((artist), release_year, album_title)
);

CREATE TABLE IF NOT EXISTS songbrowser.songs_by_albums (
  album_title    VARCHAR,
  artist         VARCHAR,
  genre          VARCHAR,
  performers     LIST<VARCHAR>,
  release_year   INT,
  song_title     VARCHAR,
  track_no       INT,
  PRIMARY KEY ((release_year, album_title), track_no)
);

CREATE TABLE IF NOT EXISTS songbrowser.songs_by_artists (
  album_title    VARCHAR,
  artist         VARCHAR,
  genre          VARCHAR,
  performers     LIST<VARCHAR>,
  release_year   INT,
  song_title     VARCHAR,
  track_no       INT,
  PRIMARY KEY ((artist), release_year, album_title, track_no)
);

CREATE CUSTOM INDEX IF NOT EXISTS album_album_title_partial ON songbrowser.albums (album_title) USING 'org.apache.cassandra.index.sasi.SASIIndex'
  WITH OPTIONS = { 'mode': 'CONTAINS' };

CREATE MATERIALIZED VIEW IF NOT EXISTS songbrowser.albums_by_genre AS
  SELECT album_title, release_year, artist, genre
  FROM songbrowser.albums
  WHERE album_title IS NOT NULL and release_year IS NOT NULL and artist IS NOT NULL and genre IS NOT NULL
  PRIMARY KEY ((genre), release_year, artist, album_title);

/** Albums */
INSERT INTO songbrowser.albums (artist, release_year, album_title, genre, record_label, producer)
VALUES ('Red Hot Chili Peppers', 2002, 'By the Way', 'Funk', 'WMG', {name: 'Warner Music GrouXp', country_code: 'us'});

INSERT INTO songbrowser.albums (artist, release_year, album_title, genre, record_label, producer)
VALUES ('System of a Down', 2005, 'Hypnotize', 'Hard rock', 'American', {name: 'American Records', country_code: 'us'});

INSERT INTO songbrowser.albums (artist, release_year, album_title, genre, record_label, producer)
VALUES ('System of a Down', 2005, 'Mezmerize', 'Hard rock', 'American', {name: 'American Records', country_code: 'us'});

/** Songs by album */
INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Mezmerize', 1, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Soldier Side');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2005, 'Mezmerize', 2, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'BYOB');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2005, 'Mezmerize', 3, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Revenga');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2005, 'Mezmerize', 4, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Cigaro');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2005, 'Hypnotize', 1, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Soldier Side');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2005, 'Hypnotize', 2, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Attack');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2005, 'Hypnotize', 3, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Dreaming');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title) 
VALUES (2002, 'By the Way', 1, 'Red Hot Chili Peppers', 'Funk', ['Kiedis', 'Frusciante', 'Flea', 'Smith'], 'By the Way');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2002, 'By the Way', 2, 'Red Hot Chili Peppers', 'Funk', ['Kiedis', 'Frusciante', 'Flea', 'Smith'], 'Universally Speaking');

INSERT INTO songbrowser.songs_by_albums (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2002, 'By the Way', 3, 'Red Hot Chili Peppers', 'Funk', ['Kiedis', 'Frusciante', 'Flea', 'Smith'], 'This Is the Place');

/** Songs by artist */
INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Mezmerize', 1, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Soldier Side');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Mezmerize', 2, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'BYOB');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Mezmerize', 3, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Revenga');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Mezmerize', 4, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Cigaro');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Hypnotize', 1, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Soldier Side');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Hypnotize', 2, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Attack');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2005, 'Hypnotize', 3, 'System of a Down', 'Hard rock', ['Tankian', 'Malakian', 'Odadjian', 'Dolmayan'], 'Dreaming');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2002, 'By the Way', 1, 'Red Hot Chili Peppers', 'Funk', ['Kiedis', 'Frusciante', 'Flea', 'Smith'], 'By the Way');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2002, 'By the Way', 2, 'Red Hot Chili Peppers', 'Funk', ['Kiedis', 'Frusciante', 'Flea', 'Smith'], 'Universally Speaking');

INSERT INTO songbrowser.songs_by_artists (release_year, album_title, track_no, artist, genre, performers, song_title)
VALUES (2002, 'By the Way', 3, 'Red Hot Chili Peppers', 'Funk', ['Kiedis', 'Frusciante', 'Flea', 'Smith'], 'This Is the Place');
