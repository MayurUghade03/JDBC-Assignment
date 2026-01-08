import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Methods {
    public static void insert(Connection conn, Scanner sc) throws Exception{
        System.out.println("Insert product info:");
        try{
            String Query = "Insert into product values(?,?,?,?)";

            System.out.println("Enter ProductID: ");
            int id = sc.nextInt();
            System.out.println("Enter product name : ");
            String name = sc.next();
            System.out.println("Enter product price: ");
            double price = sc.nextDouble();
            System.out.println("Enter product Quantity: ");
            int quantity = sc.nextInt();

            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setDouble(3,price);
            stmt.setInt(4,quantity);

            int count = stmt.executeUpdate();
            System.out.println("Product info Inserted....");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updated(Connection conn, Scanner sc ) throws Exception{
        try{
            String Query = "update product set id = ?,quantity = ? where name = ?";
            System.out.println("Enter the name:");
            String name = sc.next();
            System.out.println("Enter ID:");
            int id = sc.nextInt();
            System.out.println("Enter the quantity:");
            int quantity = sc.nextInt();

            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1,id);
            stmt.setInt(2,quantity);
            stmt.setString(3,name);

            int count = stmt.executeUpdate();
            System.out.println("Table updated successfully....");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(Connection conn, Scanner sc) throws Exception{
        try{
            String Query = "delete from product where id = ?";
            System.out.println("Enter ProductId:");
            int id = sc.nextInt();

            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setInt(1,id);
            int count = stmt.executeUpdate();
            System.out.println("Product deleted successfully...");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

