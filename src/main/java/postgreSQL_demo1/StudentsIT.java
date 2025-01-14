package postgreSQL_demo1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentsIT {
    public static void main(String[] args) {
        // Database connection
        try (Connection connection = DatabaseConnection.connect()) {
            if (connection != null) {
                // SQL query to retrieve data
                String query = "SELECT * FROM StudentsIT";

                // creating the Statement
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                // Result set
                while ((rs).next()) {
                    int id = rs.getInt("StudentId");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String address = rs.getString("Adress");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");

                    System.out.println("StudentID: " + id + ", First name: " + firstName + ", Last name: " + lastName +
                            ", Address: " + address + ", Email: " + email +
                            ", Phone number: " + phone);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
