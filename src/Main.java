import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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
                    System.out.println("4 : Delete Data");
                    System.out.println("5 : Exit");

                    System.out.println("\nEnter your choice :: ");
                    choice = scan.nextInt();

                    switch (choice) {
                        case 1 -> retrieveData(con);
                        case 2 -> insertData(con, scan);
                        case 3 -> updateData(con, scan);
                        case 4 -> deleteData(con, scan);
                        case 5 -> exit();

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

    private static void deleteData(Connection con, Scanner scan) {

        try {
            String dltQuery="DELETE FROM employees where eid=20251102";
            int rs=0;

            Statement stmt= con.createStatement();
            rs= stmt.executeUpdate(dltQuery);

            if (rs > 0) {
                System.out.println(rs + " Employee(s) deleted ✅");
            } else {
                System.out.println("Employee not deleted ⛔ (maybe eid not found)");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static void updateData(Connection con, Scanner scan) {
        try {
            boolean t = true;

            while (t) {
                System.out.println("\n1 : Change name ");
                System.out.println("2 : Change department ");
                System.out.println("3 : Change salary ");
                System.out.println("4 : Exit ");
                System.out.print("Enter update choice :: ");
                int uc = scan.nextInt();

                Statement stmt = con.createStatement();
                int rs = 0;

                switch (uc) {
                    case 1:
                        String uName = "UPDATE employees SET ename = 'Pratik' WHERE eid = 20251102";
                        rs = stmt.executeUpdate(uName);
                        break;

                    case 2:
                        String uDept = "UPDATE employees SET edept = 'IT' WHERE eid = 20251102";
                        rs = stmt.executeUpdate(uDept);
                        break;

                    case 3:
                        String uSal = "UPDATE employees SET esal = 30000 WHERE eid = 20251102";
                        rs = stmt.executeUpdate(uSal);
                        break;

                    case 4:
                        t = false; // exit loop
                        continue;

                    default:
                        System.out.println("Invalid choice ❌");
                        continue;
                }

                if (rs > 0) {
                    System.out.println(rs + " Employee(s) updated ✅");
                } else {
                    System.out.println("Employee not updated ⛔ (maybe eid not found)");
                }
            }

            // Example insert after loop
            String insert = "INSERT INTO employees (ename, edept, esal) VALUES ('BHAVESH', 'CSE', 23000)";
            Statement stmtInsert = con.createStatement();
            int updateRow = stmtInsert.executeUpdate(insert);

            if (updateRow > 0) {
                System.out.println(updateRow + " Employee(s) added ✅");
            } else {
                System.out.println("Employee not added ⛔");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
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