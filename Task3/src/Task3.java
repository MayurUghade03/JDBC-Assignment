import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task3{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://localhost:3306/Student_db";
        String userName = "root";
        String password = "Mayur@321";

        try{
            Class.forName(mysqlDriver);

            Connection conn = DriverManager.getConnection(mysqlUrl,userName,password);

            String Query = "Insert into students values(?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(Query);

            System.out.println("Enter the Student id:");
            int id = sc.nextInt();
            System.out.println("Enter the Student name:");
            String name = sc.next();
            System.out.println("Enter the Student age:");
            int age = sc.nextInt();

            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setInt(3,age);

            int count = stmt.executeUpdate();

            System.out.println("Record Executed: " + count);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}