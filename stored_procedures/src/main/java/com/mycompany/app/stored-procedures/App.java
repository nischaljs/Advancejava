package com.mycompany.app.stored_procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    // ⚠️ IMPORTANT: Update these constants for your setup
    private static final String DB_URL =
        "jdbc:mysql://localhost:3306/advancejava";
    private static final String DB_USER = "root"; // Your MySQL username
    private static final String DB_PASS = ""; // Your MySQL password

    // Data for the new employee
    private static final String NAME = "Jane Doe";
    private static final double SALARY = 75000.00;
    private static final String BRANCH = "New York";

    public static void main(String[] args) {
        // The SQL command to call the stored procedure
        // The structure is: {CALL procedureName(?, ?, ?)}
        String SQL_CALL = "{CALL insertEmployee(?, ?, ?)}";

        try (
            // 1. Establish the connection to the database
            Connection conn = DriverManager.getConnection(
                DB_URL,
                DB_USER,
                DB_PASS
            );
            // 2. Prepare the CallableStatement
            CallableStatement cs = conn.prepareCall(SQL_CALL);
        ) {
            System.out.println(
                "Connection successful. Calling stored procedure..."
            );

            // 3. Set the input parameters (IN variables)
            // Parameters are 1-based index (1, 2, 3...)
            cs.setString(1, NAME); // Corresponds to the 'ename' parameter
            cs.setDouble(2, SALARY); // Corresponds to the 'esalary' parameter
            cs.setString(3, BRANCH); // Corresponds to the 'ebranch' parameter

            // 4. Execute the statement
            cs.execute();

            System.out.println("✅ Employee inserted successfully!");
            System.out.println(
                "Details: Name=" +
                    NAME +
                    ", Salary=" +
                    SALARY +
                    ", Branch=" +
                    BRANCH
            );
        } catch (SQLException e) {
            System.err.println("❌ Database Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
