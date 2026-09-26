package ProyekAkhir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/db_mahasiswa";
    private static final String USER = "postgres";
    private static final String PASS = "YOUR_PASSWORD"; // pw postgres

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
