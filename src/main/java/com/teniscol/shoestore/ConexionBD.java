package com.teniscol.shoestore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {

    public static void probarConexion() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tienda",
                "root",
                "LuffyxNetsume"
             );
             Statement stmt = conn.createStatement()) {

            System.out.println("Conectado a la base ✔");

            // INSERT

            // SELECT
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("nombre") + " - " +
                    rs.getDouble("precio")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        probarConexion();
    }
}