package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "root";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            System.out.println("database connected!");

            Scanner sc = new Scanner(System.in);
            while (true) {

                System.out.println("===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter your choice : ");
                int choice = sc.nextInt();

                // ADD
                if (choice == 1) {
                    System.out.println("Enter student id: ");
                    int id = sc.nextInt();

                    System.out.println("Enter student name: ");
                    String name = sc.next();

                    System.out.println("Enter student age: ");
                    int age = sc.nextInt();

                    String sql = "INSERT INTO school (id,name,age) VALUES (?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, age);

                    int rows = ps.executeUpdate();
                    System.out.println(rows + " student added successfully!");
                }

                // VIEW

                else if (choice == 2) {
                    String sql = "SELECT * FROM school";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("id") + "   " +
                                        rs.getString("name") + "   " +
                                        rs.getInt("age"));
                    }
                }
                // update
                else if (choice == 3) {

                    System.out.print("Enter student id to update: ");
                    int id = sc.nextInt();

                    System.out.print("Enter new name: ");
                    String name = sc.next();

                    System.out.print("Enter new age: ");
                    int age = sc.nextInt();

                    String sql = "UPDATE school SET name = ?, age = ? WHERE id = ?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setInt(3, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                }

                else if (choice == 4) {

                    System.out.print("Enter student id to delete: ");
                    int id = sc.nextInt();

                    String sql = "DELETE FROM school WHERE id = ?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                }

                else if (choice == 5) {
                    System.out.println("Program exited.");

                } else {
                    System.out.println("program exited.");
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
