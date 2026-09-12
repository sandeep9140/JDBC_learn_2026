import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.SQLException;

public class Jdbc4_Statement {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement sm=con.createStatement();
            System.out.println(sm);
            System.out.println(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
