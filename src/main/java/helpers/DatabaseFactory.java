package helpers;

import java.sql.Connection;

public interface DatabaseFactory {

    Connection getConnection();
}
