import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Welcome User....");
            System.out.println("Choose below option:");
            System.out.println("1.Create Table ");
            System.out.println("2.Read Table");
            System.out.println("3.Insert data");
            System.out.println("4.Update Table");
            System.out.println("5.Delete User Record");
            System.out.println("6.Exist");

            System.out.println("Enter option:");
            int choice = sc.nextInt();


            switch (choice){
                case 1:
                    createtable();
                    break;
                case 2:
//                    System.out.println("Enter table name:");
//                    String tabel = sc.next();
                    read();
                    break;
                case 3:
//                    id pk, name, email, city, contact
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
                case 4:
                    System.out.println("Enter employee id:");
                    int idd = sc.nextInt();
                    System.out.println("Enter what you updated:");
                    String cityy = sc.next();
                    System.out.println("Enter updated info:");
                    String upcity = sc.next();

                    updated(idd,cityy,upcity);
                    break;
                case 5:
                    System.out.println("Enter employee id:");
                    int emp_id = sc.nextInt();
                    delete(emp_id);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Enter valid choice....");

            }
        }
    }
    public static void createtable() {
        try {
//            id pk, name, email, city, contact
            String Query = "Create table if not exists employees(id int primary key,name varchar(50),email varchar(50),city varchar(50),contact varchar(50))";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
            int count = stmt.executeUpdate();
            System.out.println(count+"Table is created");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void read(){
        try{
            String Query = "select * from employees";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
//            stmt.setString(1,table);
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
            System.out.println("Table read successfully..");
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
    public static void updated(int idd, String cityy, String upcity){
        try{
            String Query = "update employees  set ? = ? where id = ?";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setString(1,cityy);
            stmt.setString(2,upcity);
            stmt.setInt(3,idd);
            int count = stmt.executeUpdate();
            System.out.println(count + "Record update successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void delete(int emp_id){
        try{
            String Query = "delete from employees where id = ?";
            Connection conn = DBJava.connect();
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1,emp_id);
            int count = stmt.executeUpdate();
            System.out.println(count + "Record deleted successfully....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    }
