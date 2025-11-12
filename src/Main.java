import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Main {
    public static String url="jdbc:mysql://localhost:3306/test";
    public static String user="root";
    public static String pswd="";

    static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ JDBC Drive is connected successfully....");

            try {
                Connection con= DriverManager.getConnection(url, user, pswd);
                System.out.println("✅ Database is connected successfully....");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}