package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc3_resultset {
    public static void main(String[] args) {
         String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";

        try (
            Connection con=DriverManager.getConnection(url,user,pass)){
            String sql="INSERT INTO students(id,name,age) VALUES(?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setString(2,"vijay");
            ps.setInt(3, 33);

            int rows=ps.executeUpdate();
            System.out.println(rows);
    
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    
}