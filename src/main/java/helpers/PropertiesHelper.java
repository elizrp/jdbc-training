package helpers;

import helpers.constants.Constants;

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
        try (FileInputStream file = new FileInputStream(Constants.PATH_TO_PROPERTIES_FILE)) {
            Properties properties = new Properties();
            properties.load(file);

            this.url = properties.getProperty(Constants.DATABASE_URL);
            this.username = properties.getProperty(Constants.DATABASE_USERNAME);
            this.password = properties.getProperty(Constants.DATABASE_PASSWORD);
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