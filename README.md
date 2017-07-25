# cassandra-trainings-crud-template
CRUD application template for Cassandra for Developers training.

# Requirements
- Java 8
- sbt
- curl

## Running application on default port
`sbt run` inside `cassandra-crud-rest` directory

## Running application on custom port XYZ
`sbt -Dhttp.port=XYZ run` inside `cassandra-crud-rest` directory

# Example POST queries
## Posting a new album:
`curl -H "Content-Type: application/json" -X POST -d '{"artist":"artist", "releaseYear":2002, "albumTitle":"album title", "genre":"genre", "producer":"producer", "recordLabel":"record label"}' http://localhost:9000/album`

## Posting a new song:
`curl -H "Content-Type: application/json" -X POST -d '{"albumTitle":"album title", "artist":"artist", "genre":"genre", "performers":["performer 1", "performer 2"], "releaseYear":2002, "songTitle":"song title", "trackNo":0}' http://localhost:9009/song`
