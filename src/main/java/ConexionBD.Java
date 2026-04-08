import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {

    public static void probarConexion() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tienda",
                "root",
                "LuffyxNetsume"
            );

            System.out.println("Conectado a la base ✔");

            Statement stmt = conn.createStatement();

            // INSERT
            stmt.executeUpdate(
                "INSERT INTO productos (nombre, precio) VALUES ('Botas', 150000)"
            );

            // SELECT
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("nombre") + " - " +
                    rs.getDouble("precio")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}