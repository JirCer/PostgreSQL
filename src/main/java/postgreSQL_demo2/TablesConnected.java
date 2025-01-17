package postgreSQL_demo2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// 2 tables connected - statesV4 + economyV4
public class TablesConnected {
    public static void main(String[] args) {
        // Database connection
        try (Connection connection = DatabaseConnection.connect()) {
            if (connection != null) {
                // SQL query to retrieve data
                String query = """
                        SELECT statesV4.name, statesV4.area, statesV4.population, statesV4.language,\s
                        economyV4.GDPbillion, economyV4.HDI, economyV4.currency
                        FROM statesV4
                        FULL JOIN economyV4
                        ON economyV4.ID_ECO=statesV4.ID;""";

                // creating the Statement
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                // Result set
                while ((rs).next()) {
                    String name = rs.getString("Name");
                    String area = rs.getString("Area");
                    int population = rs.getInt("Population");
                    String language = rs.getString("Language");
                    int GDPbillion = rs.getInt("GDPbillion");
                    double HDI = rs.getDouble("HDI");
                    String currency = rs.getString("Currency");

                    System.out.println( "Name: " + name + ", Area: " + area +
                            ", Population: " + population + ", Language: " + language +
                             ", GDPbillion: " + GDPbillion + ", HDI: "+ HDI +
                            ", Currency: " + currency);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
