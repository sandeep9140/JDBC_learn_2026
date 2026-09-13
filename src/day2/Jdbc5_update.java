package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc5_update {
    public static void main(String[] args) {
          String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";
        try (Connection con=DriverManager.getConnection(url,user,pass)) {
            String sql="UPDATE students SET age=40, name='tillu kaliya from california' WHERE id=2";

            PreparedStatement ps=con.prepareStatement(sql);

            int result=ps.executeUpdate();
            System.out.println("updated");
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
