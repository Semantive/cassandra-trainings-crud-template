package dao;

import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.CQLDataSet;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;

abstract public class AbstractDAOTest {

    protected void setupCassandra() {
        try {
            EmbeddedCassandraServerHelper.startEmbeddedCassandra("custom.cassandra.yaml");

            final CQLDataSet dataSet = new ClassPathCQLDataSet("create-db.cql");
            final CQLDataLoader dataLoader = new CQLDataLoader(EmbeddedCassandraServerHelper.getSession());
            dataLoader.load(dataSet);

        } catch(Exception e) {
            throw new RuntimeException("Failed to initialize tests", e);
        }
    }
}
