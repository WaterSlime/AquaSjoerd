import com.google.protobuf.StringValue;

import javax.swing.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class TestSQL {
    public static void main(String[] args) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

            while (resultSet.next()) {
                int liters = resultSet.getInt("inhoud");
                System.out.println(liters);
            }

        } catch (SQLException e) {
            System.out.println("Error in de database");
        }
    }
}
