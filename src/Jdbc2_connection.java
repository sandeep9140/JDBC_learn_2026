import java.sql.DriverManager;
import  java.sql.Connection;
import java.sql.SQLException;

public class Jdbc2_connection {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="root";

        try(
        Connection con=DriverManager.getConnection(url,username,password)){

        
        System.out.println("connection stablished------------");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
}