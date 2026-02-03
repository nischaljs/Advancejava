import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javapresentation";
        String user = "root";
        String password = "";

        try {
            // Connect to database
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            // Create table using Statement
            Statement stmt = con.createStatement();

            String createTableSQL =
                "CREATE TABLE IF NOT EXISTS students (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "age INT" +
                ")";

            stmt.execute(createTableSQL);
            System.out.println("Table ready");

            // Insert data using PreparedStatement
            String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(insertSQL);

            ps.setString(1, "Ripesh");
            ps.setInt(2, 10);
            ps.executeUpdate();

            ps.setString(1, "Nischal");
            ps.setInt(2, 12);
            ps.executeUpdate();

            System.out.println("Data inserted");

            // Close everything
            ps.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
