import java.util.Scanner;

import static java.lang.Class.forName;

public class Main {
    static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ JDBC Drive is connected successfully....");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}