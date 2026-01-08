import java.sql.Connection;
import java.util.Scanner;

public class Main{
    public static void main(String [] args) throws Exception{
        Connection conn = PropertyLoader.getConnection();

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Welcome User....");
            System.out.println("1.Insert Item");
            System.out.println("2.Update Table");
            System.out.println("3.Deleted Product");
            System.out.println("4.Exist");

            System.out.println("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    Methods.insert(conn,sc);
                    break;
                case 2:
                    Methods.updated(conn, sc);
                    break;
                case 3:
                    Methods.delete(conn, sc);
                    break;
                case 4:
                    running = false;
                    break;
            }

        }
    }
}