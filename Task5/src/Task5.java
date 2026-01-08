import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) throws Exception {
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://localhost:3306/Student_db";
        String username = "root";
        String passwod = "Mayur@321";

        Scanner sc = new Scanner(System.in);

        try{
            Class.forName(mysqlDriver);
            Connection conn = DriverManager.getConnection(mysqlUrl,username,passwod);
            String Query = "delete from students where id = ?";

            PreparedStatement stmt = conn.prepareStatement(Query);

            System.out.println("Enter the Student ID:");
            int id = sc.nextInt();

            stmt.setInt(1,id);

           int count =  stmt.executeUpdate();

           System.out.println("Recorded Deleted Successfully : " + count);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    }