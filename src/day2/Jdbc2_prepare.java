package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc2_prepare {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";
        try (Connection con=DriverManager.getConnection(url,user,pass)) {
            String sql="INSERT INTO students (id,name,age) VALUES(?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "sandeep");
            ps.setInt(3, 23);
            System.out.println("insert done");

            int result=ps.executeUpdate();
            System.out.println(result);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
