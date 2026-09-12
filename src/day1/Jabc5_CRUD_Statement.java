
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jabc5_CRUD_Statement {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root";

        try (
            // Connection
            Connection con = DriverManager.getConnection(url, username, password)
        ) {

            System.out.println("Connected ..............");

            // Statement
            Statement sm = con.createStatement();

            System.out.println("Statement ready");


            /* ====================================================
               SELECT - READ
               executeQuery() -> ResultSet
               ==================================================== */

            System.out.println("\n========== OLD DATA ==========");

            ResultSet rs = sm.executeQuery(
                "SELECT * FROM student"
            );

            while (rs.next()) {

                System.out.print(rs.getInt("id") + "  ");
                System.out.print(rs.getString("name") + "  ");
                System.out.print(rs.getInt("age") + "  ");
                System.out.println(rs.getString("city"));
            }


            /* ====================================================
               INSERT - CREATE
               executeUpdate() -> int
               ==================================================== */

            System.out.println("\n========== INSERT ==========");

            String insertSql =
                "INSERT INTO student (name, age, city) VALUES " +
                "('Rahul', 20, 'Delhi'), " +
                "('Pahul', 21, 'Noida'), " +
                "('Aman', 22, 'Greater Noida')";

            int insertedRows = sm.executeUpdate(insertSql);

            System.out.println(
                insertedRows + " rows inserted"
            );


            /* ====================================================
               SELECT AFTER INSERT
               ==================================================== */

            System.out.println("\n========== DATA AFTER INSERT ==========");

            ResultSet rs2 = sm.executeQuery(
                "SELECT * FROM student"
            );

            while (rs2.next()) {

                System.out.print(rs2.getInt("id") + "  ");
                System.out.print(rs2.getString("name") + "  ");
                System.out.print(rs2.getInt("age") + "  ");
                System.out.println(rs2.getString("city"));
            }


            /* ====================================================
               UPDATE
               executeUpdate() -> int
               ==================================================== */

            System.out.println("\n========== UPDATE ==========");

            String updateSql =
                "UPDATE student " +
                "SET age = 25, city = 'Gurgaon' " +
                "WHERE name = 'Rahul'";

            int updatedRows = sm.executeUpdate(updateSql);

            System.out.println(
                updatedRows + " rows updated"
            );


            /* ====================================================
               SELECT AFTER UPDATE
               ==================================================== */

            System.out.println("\n========== DATA AFTER UPDATE ==========");

            ResultSet rs3 = sm.executeQuery(
                "SELECT * FROM student"
            );

            while (rs3.next()) {

                System.out.print(rs3.getInt("id") + "  ");
                System.out.print(rs3.getString("name") + "  ");
                System.out.print(rs3.getInt("age") + "  ");
                System.out.println(rs3.getString("city"));
            }


            /* ====================================================
               DELETE
               executeUpdate() -> int
               ==================================================== */

            System.out.println("\n========== DELETE ==========");

            String deleteSql =
                "DELETE FROM student " +
                "WHERE name = 'Pahul'";

            int deletedRows = sm.executeUpdate(deleteSql);

            System.out.println(
                deletedRows + " rows deleted"
            );


            /* ====================================================
               FINAL SELECT
               ==================================================== */

            System.out.println("\n========== FINAL DATA ==========");

            ResultSet rs4 = sm.executeQuery(
                "SELECT * FROM student"
            );

            while (rs4.next()) {

                System.out.print(rs4.getInt("id") + "  ");
                System.out.print(rs4.getString("name") + "  ");
                System.out.print(rs4.getInt("age") + "  ");
                System.out.println(rs4.getString("city"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
