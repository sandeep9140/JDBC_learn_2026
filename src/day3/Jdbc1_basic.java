package day3;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Jdbc1_basic{
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/students";
        String user="root";
        String pass="root";

        try (Connection con=DriverManager.getConnection(url,user,pass)) {
            System.out.println("connected to database......");

            String sql="SELECT * FROM school2";
            PreparedStatement ps=con.prepareStatement(sql);

            System.out.println("prapred");

            ResultSet rs=ps.executeQuery();
            System.out.println("result set");

            while(rs.next()){
                System.out.println(rs.getInt("id")+"  "+ rs.getString("name"));
                
            }

            System.out.println("done view");


            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}