package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc2_transaction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/students";
        String user = "root";
        String pass = "root";
        Connection con=null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);

            System.out.println("connected----------------");

            String sql = "INSERT INTO school2 (id,name) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("prepare statement-----------");

            // student 1
            ps.setInt(1, 16);
            ps.setString(2, "sanjay");
            ps.executeUpdate();

            // student 2
            ps.setInt(1, 17);
            ps.setString(2, "modi");
            ps.executeUpdate();
            con.commit();

            System.out.println("both added");

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("undo save");
                }

            } catch (Exception ex) {
                // TODO: handle exception
            }
            // TODO: handle exception
        }
    }

}
