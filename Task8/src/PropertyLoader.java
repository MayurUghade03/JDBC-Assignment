import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class PropertyLoader {
    public static final String DRIVER;
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;
    static {
        Properties properties = new Properties();
        try {
            // Load a file and set the Properties in to Propertied object
            properties.load(new FileInputStream("Resources/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER = properties.getProperty("db.driver");
        URL = properties.getProperty("db.url");
        USER = properties.getProperty("db.user");
        PASSWORD = properties.getProperty("db.password");
    }
    public static final Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(PropertyLoader.DRIVER);
            con = DriverManager.getConnection(PropertyLoader.URL, PropertyLoader.USER, PropertyLoader.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
