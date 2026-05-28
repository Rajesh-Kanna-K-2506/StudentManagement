import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {

    static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "your_password");

            System.out.println("Database Connected");

        }
        catch (Exception e) {

            System.out.println(e);
        }

        return con;
    }
}