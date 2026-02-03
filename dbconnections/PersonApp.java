import java.sql.*;
import java.util.Scanner;

public class PersonApp {

    private static final String URL = "jdbc:mysql://localhost:3306/advancejava";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert Person");
            System.out.println("2. Delete Person");
            System.out.println("3. Display All Persons");
            System.out.println("4. Display Persons age >= 18");
            System.out.println("5. Update Person Age");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> insertPerson(sc);
                case 2 -> deletePerson(sc);
                case 3 -> displayPersons();
                case 4 -> displayAdults();
                case 5 -> updateAge(sc);
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    //------------------ INSERT PERSON -----------------------
    private static void insertPerson(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Address: ");
            String Address = sc.next();

            String sql =
                "INSERT INTO person(id, name, age, Address) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, Address);

            int rows = ps.executeUpdate();
            System.out.println(
                rows > 0 ? "Inserted successfully!" : "Insert failed."
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------ DELETE PERSON -----------------------
    private static void deletePerson(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM person WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(
                rows > 0 ? "Deleted successfully!" : "Person not found."
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------ DISPLAY ALL PERSONS -----------------------
    private static void displayPersons() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM person";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID | Name | Age | Address");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") +
                        " | " +
                        rs.getString("name") +
                        " | " +
                        rs.getInt("age") +
                        " | " +
                        rs.getString("Address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------ DISPLAY AGE >= 18 -----------------------
    private static void displayAdults() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM person WHERE age >= 18";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nAdults (Age >= 18):");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") +
                        " | " +
                        rs.getString("name") +
                        " | " +
                        rs.getInt("age") +
                        " | " +
                        rs.getString("Address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------ UPDATE AGE -----------------------
    private static void updateAge(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter ID to update age: ");
            int id = sc.nextInt();
            System.out.print("Enter new age: ");
            int age = sc.nextInt();

            String sql = "UPDATE person SET age = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, age);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(
                rows > 0 ? "Updated successfully!" : "Person not found."
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
