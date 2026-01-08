import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Tables {
    public static void createTable(Connection conn, Scanner sc) throws SQLException {
        try {
            String Query = "Create table if not exists product(id int primary key,name varchar(30),price double,quantity int)";
            PreparedStatement stmt = conn.prepareStatement(Query);
            int count = stmt.executeUpdate();
            System.out.println(count+"Table is created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
