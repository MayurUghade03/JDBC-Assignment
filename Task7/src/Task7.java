import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean b = true;
        while (b){
            System.out.println("Welcome User....");
            System.out.println("1.Insert Info");
            System.out.println("2.Update Info");
            System.out.println("3.Get Info");
            System.out.println("4.Exist");

            System.out.println("Choose the option:");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the employee id:");
                    int id = sc.nextInt();
                    System.out.println("Enter the employee name:");
                    String name = sc.next();
                    System.out.println("Enter the employee email:");
                    String email = sc.next();
                    System.out.println("Enter the employee city:");
                    String city = sc.next();
                    System.out.println("Enter the employee contact:");
                    String contact = sc.next();
                    insert(id, name, email, city, contact);
                    break;
                case 2:
                    System.out.println("Enter employee id:");
                    int emp_id = sc.nextInt();
                    System.out.println("Enter employee contact_number:");
                    String contactt = sc.next();
                    update(emp_id, contactt);
                    break;
                case 3:
                    System.out.println("Enter the employee city name:");
                    String cityy = sc.next();
                    show(cityy);
                    break;
                case 4:
                    b = false;
                    break;
                default:
                    System.out.println("Enter valid choice....");

            }
        }
    }
    public static void insert(int id, String name, String email, String city, String contact){
        //            id pk, name, email, city, contact
        try{
            String Query = "insert into employees values(?,?,?,?,?)";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setString(3,email);
            stmt.setString(4,city);
            stmt.setString(5,contact);

            int count = stmt.executeUpdate();
            System.out.println(count + "Record inserted successfully...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void update(int emp_id, String contact){
        try{
            String Query = "update employees set contact = ? where id = ?";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setString(1,contact);
            stmt.setInt(2,emp_id);

            int count = stmt.executeUpdate();
            System.out.println(count + "Record updated successfully....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void show(String city){
        try{
            String Query = "select * from employees where city = ?";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setString(1,city);
            ResultSet rs = stmt.executeQuery();
            System.out.println("id\tname\temail\tcity\tcontact");
            while (rs.next()){
                System.out.print(rs.getInt("id") + "\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.print(rs.getString("email") + "\t");
                System.out.print(rs.getString("city") + "\t");
                System.out.print(rs.getString("contact") + "\t");
                System.out.println();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}