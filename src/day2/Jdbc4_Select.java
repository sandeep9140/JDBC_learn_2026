package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc4_Select {
    public static void main(String[] args) {
         String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";

        try (Connection con=DriverManager.getConnection(url,user,pass)) {
            String sql="SELECT * FROM students";

            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(
                    rs.getInt("id")+" "+
                    rs.getString("name")+" "+
                    rs.getInt("age")
                );
            }

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
