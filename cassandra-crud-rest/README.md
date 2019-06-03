# Building and running the application

sbt is used as the tool to manage dependencies, compile and run the application. 

## Configuration
Configuration is done by env variables and can be used to point to Cassandra cluster and keyspace. Variables and their default values are:
- `CASSANDRA_HOST="127.0.0.1"`
- `CASSANDRA_KEYSPACE="songbrowser"`

## Running as a developer

Open the terminal and execute:
`sbt run`

## Running tests
To run tests, open the terminal and execute:
`sbt test`

Part of the Cassandra course is to finish implementation of this application. Out of the box the tests will fail - please work on DAO implementation to make them pass.
 
The tests are using cassandra-unit package to create and run Cassandra cluster with one host. You do not need to run a separate cluster for test phase.

## Building JAR package

Open the terminal and execute: 
`sbt package`

Artifact (JAR package) can be found in `./target/scala-2.12/` directory. 

## Troubleshooting

### sbt fails to run
**Problem:** sbt shows `[ERROR] Failed to construct terminal; falling back to unsupported` message

**Solution:** run with `TERM=xterm-color` env variable.