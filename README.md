# cassandra-trainings-crud-template
CRUD application template for Cassandra for Developers training.

# Exercise overview
This exercise is meant to practice usage of Datastax' Cassandra Driver for Java, especially it's mapper module. User is is meant to fill in all `FixMe` gaps with working code.

## How to approach the exercise
### Ensuring that your machine fulfills requirements
- installed and working Cassandra DB, cqlsh
- sbt
- curl

### Preparing database schema
1. Load schema from the `create-schema.cql` file: `cql -f create-schema.cql`. It will create a `songbrowser` keyspace with all necessary contents.
2. Optionally (but recommended), load sample data into the tables by using `cql -f insert-data.cql`.

Next, run application as-is, without any changes in the source code:

### Running application on default port
Run `sbt run` inside `cassandra-crud-rest` directory.

### Running application on custom port XYZ
Run `sbt -Dhttp.port=XYZ run` inside `cassandra-crud-rest` directory.

### Running tests (on default port only)
Run `sbt test` inside inside `cassandra-crud-rest` directory. Make sure you do not have any application listening on port 9000 (including other Cassandra instances).

### Exploring GET endpoints 
Try querying following endpoints to see how the application behaves (remember to use appropriate port!). Word beginning with colon (`:`) should be substituted with a value. Use internet browser as a client:
- `http://localhost:9000/albums/:artist` - returns all albums for a given artist,
- `http://localhost:9000/albums/search/:title` - returns all albums which title contains given phrase,
- `http://localhost:9000/songs/:artist` - returns all songs for a given artist,
- `http://localhost:9000/songs/paginate/:artist` - returns all songs for a given artist as a paginable list, 1st page only,
- `http://localhost:9000/songs/paginate/:artist?page=N` - returns all songs for a given artist as a paginable list, Nth page only,
- `http://localhost:9000/songs/:release_year/:album_title` - returns all songs from the given album (by title and release year).

### Exploring POST endpoints:
- `http://localhost:9000/album` for adding a new album (or updating existing one, remember INSERT / UPDATE operations in Cassandra),
- `http://localhost:9000/song` for adding or updating a song.

## Doing exercise
1. Ensure you know how the application works.
2. Fill in `CassandraSupport` class to add missing Mappers.
3. Fill in `getXYZ` and `saveXYZ` methods in all classes in DAO classes.
4. Take a look at sample tests suite (AlbumsDAOTest).
5. Fill in gaps in `SongsByAlbumDAOTest` and `SongsByArtistDAOTest`.
 
You can verify your results using the tests. For debugging consider using `cqlsh` or `DevCenter` tool.
