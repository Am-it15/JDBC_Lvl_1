import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Main {
    public static String url="jdbc:mysql://localhost:3306/test";
    public static String user="root";
    public static String pswd="";


    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ JDBC Drive is connected successfully....");

            try {
                Connection con = DriverManager.getConnection(url, user, pswd);
                System.out.println("✅ Database is connected successfully....");

                int choice;
                do {
                    System.out.println("================================== Basic JDBC ==================================");
                    System.out.println("1 : Retrieve Data");
                    System.out.println("2 : Insert Data");
                    System.out.println("3 : Update Data");
                    System.out.println("4 : Exit");

                    System.out.println("\nEnter your choice :: ");
                    choice = scan.nextInt();

                    switch (choice) {
                        case 1 -> retrieveData(con);
                        case 2 -> insertData(con, scan);
                        case 3 -> updateData(con, scan);
                        case 4 -> exit();

                        default -> System.out.println("⛔ Enter valid input");

                    }

                } while (true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateData(Connection con, Scanner scan) {

    }

    private static void exit() {
        System.out.println("Bye Bye 👋");
        System.exit(0);
    }

    private static void insertData(Connection con, Scanner scan) {
        try {
            String insert = "INSERT INTO employees (ename, edept, esal) VALUES ('BHAVESH', 'CSE', 23000)";

            Statement stmt = con.createStatement();
            int updateRow = stmt.executeUpdate(insert);

            if (updateRow > 0) {
                System.out.println(updateRow + " Employee(s) added ✅");
            } else {
                System.out.println("Employee not added ⛔");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void retrieveData(Connection con) {
        int n=0;
        try {
            String retrieve="SELECT * FROM EMPLOYEEs";

            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(retrieve);

            while (rs.next()) {
                int id= rs.findColumn("eid");
                String name= rs.getString("ename");
                String dept=rs.getString("edept");
                double sal= rs.findColumn("esal");

                System.out.println("========== DATA NO. "+n+" ==========");
                System.out.println("Employee id :: "+id);
                System.out.println("Employee Name :: "+name);
                System.out.println("Employee Department :: "+dept);
                System.out.println("Employee Salary :: "+sal);

                n++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}