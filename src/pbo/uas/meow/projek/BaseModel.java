package pbo.uas.meow.projek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseModel {
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    public static Connection connection;

    public BaseModel() throws SQLException{
        dbUrl = "jdbc:postgresql://localhost/meowapp";
        dbUser = "postgres";
        dbPassword = "liONpro12";

        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
