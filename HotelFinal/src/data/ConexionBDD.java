/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import DAO.HabitacionesDao;
import DAO.PasajerosDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danie
 */
public class ConexionBDD {
  
      
   
        public static Connection getConnection() throws SQLException {
       
        String url = "jdbc:sqlite:../../../proyectosgit/ProyectoHotel pasajeros-habitaciones/HotelFinal/BDD.s3db";
        
        return DriverManager.getConnection(url); 
    }
     
   public static void main(String[] args) {
        
     Connection conexion = null;     
           try {
             conexion = ConexionBDD.getConnection();
             HabitacionesDao habitacionesDao = new HabitacionesDao(conexion);

    
             if (conexion != null) {
            System.out.println("Conexión establecida con éxito");
            
        
        } else {
            System.out.println("Error al establecer conexión");
        }
             
        } catch (SQLException e) {
    } finally {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
        }
    }
   try {
             conexion = ConexionBDD.getConnection();
             
             PasajerosDao pasajerosDao = new PasajerosDao(conexion);
             if (conexion != null) {
            System.out.println("Conexión establecida con éxito");
        } else {
            System.out.println("Error al establecer conexión");
        }
             
        } catch (SQLException e) {
    } finally {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
        }
    }
   }
    
}




    

