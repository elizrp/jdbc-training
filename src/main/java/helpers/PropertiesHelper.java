package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private final String url, username, password;

    private static PropertiesHelper propertiesHelper;

    static {
        try {
            propertiesHelper = new PropertiesHelper();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PropertiesHelper() throws IOException {

        // passed in try-with-resources statement, object 'file' will be automatically closed at the end
        try (FileInputStream file = new FileInputStream("./src/main/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(file);

            this.url = properties.getProperty("jdbc.postgres.url");
            this.username = properties.getProperty("jdbc.postgres.username");
            this.password = properties.getProperty("jdbc.postgres.password");
        }
    }

    public static PropertiesHelper getHelper() {
        return propertiesHelper;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}