import java.sql.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class TestSQL {
    public static void main(String[] args) {

        try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://MyDatabaseServer/MyDatabase", "root", "Rinnegan999!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from aquasjoerd.klant");

            while (resultSet.next()){
                System.out.println(resultSet.getString("Naam"));

            }

        } catch (SQLException e) {
            System.out.println("Error in de database");;
        }
    }
}
