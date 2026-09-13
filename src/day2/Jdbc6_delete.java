package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc6_delete {
    public static void main(String[] args) {
          String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";

        try (Connection con=DriverManager.getConnection(url,user,pass)) {
            String sql="DELETE FROM students where id=1";

            PreparedStatement ps=con.prepareStatement(sql);
            int result=ps.executeUpdate();
            System.out.println(result+" result updated---------------");
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
