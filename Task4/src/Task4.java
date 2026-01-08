import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws Exception {
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://localhost:3306/Student_db";
        String userName = "root";
        String password = "Mayur@321";
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName(mysqlDriver);
            Connection conn = DriverManager.getConnection(mysqlUrl,userName,password);

//            String query = "alter table students add column marks int default 0";

            String Query = "update students set marks = ? where id = ?";

            PreparedStatement stmt = conn.prepareStatement(Query);

            System.out.println("Enter the Student Id:");
            int id =sc.nextInt();

            System.out.println("Enter the Student Marks:");
            int marks = sc.nextInt();

            stmt.setInt(1,marks);
            stmt.setInt(2,id);

           int count =  stmt.executeUpdate();

            System.out.println("Record Updated Successfully :" + count);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}