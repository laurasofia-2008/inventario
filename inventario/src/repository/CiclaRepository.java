package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.Conexion;
import java.sql.Statement;

import model.Cicla;

public class CiclaRepository {

    public void insertarCicla(Cicla cicla) {
        String sql = "INSERT INTO cicla (marca, modelo, color) VALUES (?, ?, ?)";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cicla.getMarca());
            preparedStatement.setString(2, cicla.getModelo());
            preparedStatement.setString(3, cicla.getColor());

            preparedStatement.executeUpdate();
            System.out.println("Bicicleta insertada.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cicla> listarCiclas() {
        List<Cicla> ciclas = new ArrayList<>();
        String sql = "SELECT * FROM cicla";

        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                ciclas.add(new Cicla(
                        resultSet.getLong("id"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("color")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ciclas;
    }

    public void actualizarCicla(Long id, String nuevaMarca, String nuevoModelo, String nuevoColor) {
        String sql = "UPDATE cicla SET marca = ?, modelo = ?, color = ? WHERE id = ?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nuevaMarca);
            preparedStatement.setString(2, nuevoModelo);
            preparedStatement.setString(3, nuevoColor);
            preparedStatement.setLong(4, id);

            int filasActualizadas = preparedStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Bici actualizada.");
            } else {
                System.out.println("No se encontró ninguna Cicla con ese ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarCicla(Long id) {
        String sql = "DELETE FROM cicla WHERE id = ?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            int filasEliminadas = preparedStatement.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Bici eliminada");
            } else {
                System.out.println("No se encontró ninguna cicla con ese ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}