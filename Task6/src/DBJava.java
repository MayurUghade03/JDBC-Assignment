import java.sql.Connection;
import java.sql.DriverManager;

public class DBJava {
    static Connection conn = null;

    public static Connection connect(){
        try{
//        Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student_db",
                    "root",
                    "Password");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

}
