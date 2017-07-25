package models;


import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "songbrowser", name = "producer")
public class Producer {

    @Field(name = "name")
    private String name;

    @Field(name = "country_code")
    private String countryCode;

    public Producer() {
    }

    public Producer(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public Producer setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Producer setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }
}
