/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entities.Pasajeros;
import Excepciones.DuplicateEntryException;
import Excepciones.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author danie
 */
public class PasajerosDao implements Dao<Pasajeros> {
    
     private Connection conexion;
     private static List <Pasajeros> list=new ArrayList();
     private Pasajeros pasajeros;

    public PasajerosDao(Connection conexion) throws SQLException {
       
        this.conexion = conexion;
    }

   
    @Override
    public void save(Pasajeros pasajeros){
       String sql = "INSERT INTO Pasajeros (nombres, apellidos, documentoId, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
           statement.setString(1, pasajeros.getNombre());
           statement.setString(2, pasajeros.getApellido());
           statement.setLong(3, pasajeros.getDni());
           statement.setLong(4, pasajeros.getTelefono());
           statement.setString(5, pasajeros.getEmail());
           statement.executeUpdate();
        }
       catch (SQLException e){
           throw new RuntimeException("Error al guardar pasajeros: " + e.getMessage(), e);
    }
    }
    
    @Override
    public Pasajeros getById(int id) throws NotFoundException {
        String sql = "SELECT * FROM Pasajeros where IdPasajero = ?";
         try (PreparedStatement statement = conexion.prepareStatement(sql)) {
           statement.setInt(1, id); 
           ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            pasajeros = new Pasajeros(
                resultSet.getString("nombres"),
                resultSet.getString("apellidos"),
                resultSet.getLong("documentoId"),
                resultSet.getLong("telefono"),
                resultSet.getString("email")
                
            );
            pasajeros.setIdPasajero(resultSet.getLong("IdPasajero"));
            pasajeros.setIdPasajero(resultSet.getInt("estado"));
            
        } else {
            throw new NotFoundException("No se encontró el pasajero con id: " + id);
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al acceder a la base de datos", e);
    }

    return pasajeros;
}   

    @Override
    public List <Pasajeros> listAll() {
        List<Pasajeros> list = new ArrayList<>(); 
        String sql = "SELECT * FROM Pasajeros";
         try (PreparedStatement statement = conexion.prepareStatement(sql)){
         ResultSet resultSet = statement.executeQuery(); 
        
        while (resultSet.next()) {
                pasajeros = new Pasajeros(
                resultSet.getString("nombres"),
                resultSet.getString("apellidos"),
                resultSet.getLong("documentoId"),
                resultSet.getLong("telefono"),
                resultSet.getString("email")
                       
            );
            pasajeros.setIdPasajero(resultSet.getInt("IdPasajero"));
            pasajeros.setEstado(resultSet.getInt("estado"));
            list.add(pasajeros);
        }
     }catch (SQLException e) {
        throw new RuntimeException("Error al listar pasajeros: " + e.getMessage(), e);
    }
       
       return list;
                }
    
    @Override
    public void update(Pasajeros pasajero, int id) throws NotFoundException {
        String sql =  "UPDATE Pasajeros SET nombres = ?, apellidos = ?, documentoId = ?, telefono = ?, email = ? WHERE idPasajero = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setString(1, pasajero.getNombre());
        statement.setString(2, pasajero.getApellido());
        statement.setLong(3, pasajero.getDni());
        statement.setLong(4, pasajero.getTelefono()); 
        statement.setString(5, pasajero.getEmail()); 
        statement.setInt(6, id);
        
        int filaActualizada = statement.executeUpdate();
        if (filaActualizada == 0) {
            throw new NotFoundException("Pasajero no encontrado para actualizar");
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al actualizar pasajero: " + e.getMessage(), e);
    }
}   

    @Override
    public void delete(Pasajeros pasajero) {
        String sql = "DELETE FROM Pasajeros where IdPasajero = ?";
        try {PreparedStatement statement = conexion.prepareStatement(sql); 
        statement.setLong(1, pasajero.getIdPasajero());
        int filaEliminada = statement.executeUpdate();
        if (filaEliminada == 0) {
            throw new NotFoundException("Pasajero no encontrado para eliminar");
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al eliminar pasajero: " + e.getMessage(), e);
    }    catch (NotFoundException ex) {
             Logger.getLogger(PasajerosDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
     
    public void deshabilitarPasajero(int id) throws NotFoundException {
    String sql = "UPDATE Pasajeros SET estado = ? WHERE estado = 1 AND IdPasajero = ?";
    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, 0); 
        statement.setInt(2, id); 
        
        int filaDeshabilitada = statement.executeUpdate();
        if (filaDeshabilitada == 0) {
            throw new NotFoundException("Pasajero no encontrado para deshabilitar");
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al deshabilitar pasajero: " + e.getMessage(), e);
    }
}
    public void pasajeroDuplicado(String nombres, String apellidos, Long dni, Long id) throws DuplicateEntryException, SQLException {
      String sql = "SELECT COUNT(*) FROM Pasajeros WHERE nombres = ? AND apellidos = ? AND documentoId = ? AND IdPasajero <> ?";
      try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setString(1, nombres);
        statement.setString(2, apellidos);
        statement.setLong(3, dni);
        statement.setLong(4, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                throw new DuplicateEntryException("El pasajero ya existe");
            }
        } catch (SQLException e) {
        throw new RuntimeException("Error al verificar pasajero: " + e.getMessage(), e);
    }
}
    }
    public void pasajeroDuplicadoNuevo (String nombres, String apellidos, Long dni) throws DuplicateEntryException, SQLException {
      String sql = "SELECT COUNT(*) FROM Pasajeros WHERE nombres = ? AND apellidos = ? AND documentoId = ?";
      try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setString(1, nombres);
        statement.setString(2, apellidos);
        statement.setLong(3, dni);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                throw new DuplicateEntryException("El pasajero ya existe");
            }
        } catch (SQLException e) {
        throw new RuntimeException("Error al verificar pasajero: " + e.getMessage(), e);
    }
}
    }
      public void close() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }
}




