import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc5_PreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root";

        try (
            Connection con = DriverManager.getConnection(url, username, password)){
            System.out.println("connected...................");

            String sq="INSERT INTO student(id,name,age,city) VALUES(?,?,?,?)";

            PreparedStatement ps=con.prepareStatement(sq);

            ps.setInt(1,12);
            ps.setString(2, "lallan");
            ps.setInt(3, 100);
            ps.setString(4, "lallamusa daal");

            int row=ps.executeUpdate();

            System.out.println(row+" rows executed");

            PreparedStatement sel=con.prepareStatement("SELECT * FROM student");
            ResultSet rs=sel.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.print(rs.getInt("age")+" ");
                System.out.print(rs.getString("city")+" \n");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
