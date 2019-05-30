package services;

import com.google.inject.AbstractModule;

public class Module extends AbstractModule {

    protected void configure() {
        bind(CassandraConfigurableSupport.class).asEagerSingleton();
    }
}
