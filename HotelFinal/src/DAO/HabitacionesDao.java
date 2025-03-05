/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entities.Habitaciones;
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
public class HabitacionesDao implements Dao<Habitaciones> {
    
     private Connection conexion;
     private static List <Habitaciones> list=new ArrayList();
     private Habitaciones habitacion;

    public HabitacionesDao(Connection conexion) throws SQLException {
       
        this.conexion = conexion;
    }

   
    @Override
    public void save(Habitaciones habitacion) throws DuplicateEntryException {
         try {
             habitacionDuplicada(habitacion.getNroHabitacion());
         } catch (SQLException ex) {
             Logger.getLogger(HabitacionesDao.class.getName()).log(Level.SEVERE, null, ex);
         }
       String sql = "INSERT INTO habitaciones (camasDobles, camasSimples, precioPorDia, nroHabitacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
           statement.setInt(1, habitacion.getCantCamasDobles());
           statement.setInt(2, habitacion.getCantCamasSimples());
           statement.setDouble(3, habitacion.getPrecioPorDia());
           statement.setInt(4, habitacion.getNroHabitacion());
           statement.executeUpdate();
        }
       catch (SQLException e){
           throw new RuntimeException("Error al guardar la habitación: " + e.getMessage(), e);
    }
    }
    
    @Override
    public Habitaciones getById(int id) throws NotFoundException {
        String sql = "SELECT * FROM habitaciones where Id = ?";
         try (PreparedStatement statement = conexion.prepareStatement(sql)) {
           statement.setInt(1, id); 
           ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            habitacion = new Habitaciones(
                resultSet.getInt("camasDobles"),
                resultSet.getInt("camasSimples"),
                resultSet.getDouble("precioPorDia"),
                resultSet.getInt("nroHabitacion")
            );
            habitacion.setIdHabitacion(resultSet.getInt("id"));
            habitacion.setEstado(resultSet.getInt("estado"));
            
        } else {
            throw new NotFoundException("No se encontró la habitacion con id: " + id);
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al acceder a la base de datos", e);
    }

    return habitacion;
}   

    @Override
    public List <Habitaciones> listAll() {
        List<Habitaciones> list = new ArrayList<>(); 
        String sql = "SELECT * FROM habitaciones";
         try (PreparedStatement statement = conexion.prepareStatement(sql)){
         ResultSet resultSet = statement.executeQuery(); 
        
        while (resultSet.next()) {
                habitacion = new Habitaciones(
                resultSet.getInt("camasDobles"),
                resultSet.getInt("camasSimples"),
                resultSet.getDouble("precioPorDia"),
                resultSet.getInt("nroHabitacion")
                       
            );
            habitacion.setIdHabitacion(resultSet.getInt("id"));
            habitacion.setEstado(resultSet.getInt("estado"));
            list.add(habitacion);
        }
     }catch (SQLException e) {
        throw new RuntimeException("Error al listar habitaciones: " + e.getMessage(), e);
    }
       
       return list;
                }
    
    @Override
    public void update(Habitaciones habitacion, int id) throws NotFoundException {
        String sql = "UPDATE habitaciones SET camasDobles = ?, camasSimples = ?, precioPorDia = ?, nroHabitacion = ? WHERE Id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, habitacion.getCantCamasDobles());
        statement.setInt(2, habitacion.getCantCamasSimples());
        statement.setDouble(3, habitacion.getPrecioPorDia());
        statement.setInt(4, habitacion.getNroHabitacion()); 
        statement.setInt(5, id);
        
        int filaActualizada = statement.executeUpdate();
        if (filaActualizada == 0) {
            throw new NotFoundException("Habitacion no encontrada para actualizar");
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al actualizar la habitación: " + e.getMessage(), e);
    }
}   

    @Override
    public void delete(Habitaciones habitacion) {
        String sql = "DELETE FROM habitaciones where Id = ?";
        try {PreparedStatement statement = conexion.prepareStatement(sql); 
        statement.setInt(1, habitacion.getIdHabitacion());
        int filaEliminada = statement.executeUpdate();
        if (filaEliminada == 0) {
            throw new NotFoundException("Habitacion no encontrada para eliminar");
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al eliminar la habitación: " + e.getMessage(), e);
    }    catch (NotFoundException ex) {
             Logger.getLogger(HabitacionesDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
     
    public void deshabilitarHabitacion(int id) throws NotFoundException {
    String sql = "UPDATE habitaciones SET estado = ? WHERE estado = 1 AND Id = ?";
    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, 0); 
        statement.setInt(2, id); 
        
        int filaDeshabilitada = statement.executeUpdate();
        if (filaDeshabilitada == 0) {
            throw new NotFoundException("Habitación no encontrada para deshabilitar");
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al deshabilitar la habitación: " + e.getMessage(), e);
    }
}
    public void habitacionDuplicada(int nrohabitacion) throws DuplicateEntryException, SQLException {
      String sql = "SELECT COUNT(*) FROM habitaciones WHERE nroHabitacion = ?";
      try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, nrohabitacion);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                throw new DuplicateEntryException("La habitación ya existe");
            }
        } catch (SQLException e) {
        throw new RuntimeException("Error al verificar la habitación: " + e.getMessage(), e);
    }
}
    }
    public void habitacionDuplicadaMod (int nrohabitacion, int id) throws DuplicateEntryException, SQLException {
      String sql = "SELECT COUNT(*) FROM habitaciones WHERE nroHabitacion = ?  AND Id <> ?";
      try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, nrohabitacion);
        statement.setInt(2, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                throw new DuplicateEntryException("La habitación ya existe");
            }
        } catch (SQLException e) {
        throw new RuntimeException("Error al verificar la habitación: " + e.getMessage(), e);
    }
}
    }
    
    
      public void close() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }
}



