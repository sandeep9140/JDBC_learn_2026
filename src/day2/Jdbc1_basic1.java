package day2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Jdbc1_basic1 {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";
        try(Connection con=DriverManager.getConnection(url,user,pass)){
            System.out.println("connected");
            Statement sm=con.createStatement();
            System.out.println("statement ready");

            //
            ResultSet rs=sm.executeQuery("SELECT * FROM student");
            System.out.println(rs);
            System.out.println("result set is ready");

            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }

        }catch(Exception e){ e.printStackTrace();}

        


        
    }

    
}
