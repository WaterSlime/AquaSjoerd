import java.sql.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class TestSQL {
    public static void main(String[] args) {
//
//        try {
//
//           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/klantendatabaseaquasjoerd", "root", "Rinnegan999!");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from klantendatabaseaquasjoerd.klant");
//
//            while (resultSet.next()){
//                String naam = resultSet.getString("Naam");
//                System.out.println((naam));
//
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error in de database");;
//        }

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from irrigatie.hoeveelheden");


            while (resultSet.next()){
                String naam = resultSet.getString("Liters");
                System.out.println(naam);

            }

        } catch (SQLException e) {
            System.out.println("Error in de database");;
        }
    }
}
