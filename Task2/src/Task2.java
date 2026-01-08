import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task2{
    public static void main(String args[]){
        String mysqlDrvier = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://localhost:3306/student_db";
        String userName = "root";
        String password = "Password";
        try{
            Class.forName(mysqlDrvier);

            Connection conn = DriverManager.getConnection(mysqlUrl,userName,password);

            String Query = "Select * from students";

            PreparedStatement stmt = conn.prepareStatement(Query);

            ResultSet rs = stmt.executeQuery();
            System.out.println("id \t\t name \t\t\t age");
            while (rs.next()) {
                System.out.print(rs.getInt("id")+"\t\t");
                System.out.print(rs.getString("name")+"\t\t\t");
                System.out.print(rs.getInt("age")+"\t\t");
                System.out.println();
            }
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }
