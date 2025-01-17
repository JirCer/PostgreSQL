package postgreSQL_demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //create a database with data, for example - in the pgadmin4 application
    // and connect it to java

    // URL database
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres"; //your username
    private static final String PASSWORD = "***your_password***"; // your password

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("The connection to the database was successful!");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }
}