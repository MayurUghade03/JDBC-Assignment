import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Task1 {
    public static void main(String args[]){

        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://localhost:3306/Student_db";
        String username = "root";
        String password = "Mayur@321";

        try{
//            1.Register Driver
            Class.forName(mysqlDriver);

//            2.Create Connection
            Connection conn = DriverManager.getConnection(mysqlUrl,username,password);

            System.out.println("Connection Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
