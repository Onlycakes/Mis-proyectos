
package Entities;

import DAO.HabitacionesDao;
import Excepciones.DuplicateEntryException;
import data.ConexionBDD;
import java.util.ArrayList;
import java.util.Objects;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Habitaciones { 
    protected int idHabitacion;
    protected int camasDobles;
    protected int camasSimples;
    protected Double precioPorDia;
    protected int nroHabitacion;
    private int estado;
    protected static ArrayList <Habitaciones> arrayListHabitacion = new ArrayList ();
    
    
    public Habitaciones(int camasDobles, int cantCamasSimples, Double precioPorDia, int nroHabitacion) {
        this.camasDobles = camasDobles;
        this.camasSimples = cantCamasSimples;
        this.precioPorDia=precioPorDia;
        this.nroHabitacion=nroHabitacion;
        
    }
    
    public void save () throws DuplicateEntryException {
    
             
            Connection connection = null;
        try {
            connection = ConexionBDD.getConnection(); 
            HabitacionesDao habitacionesDao = new HabitacionesDao(connection);
            int nro= this.getNroHabitacion();
            habitacionesDao.habitacionDuplicada(nro);
            habitacionesDao.save(this); 
        } catch (SQLException e) {
            Logger.getLogger(Habitaciones.class.getName()).log(Level.SEVERE, null, e);
            
            throw new DuplicateEntryException("Error al guardar la habitación: " + e.getMessage());
        } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }   } catch (SQLException ex) {
                    Logger.getLogger(Habitaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
         }
   
    public boolean valida () {
        if (this.camasDobles==0 && this.camasSimples==0) {
          return false;  
        }
        return true;
    }
    
    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int idHabitacion) {
        this.nroHabitacion = idHabitacion;
    }

    public int getCantCamasSimples() {
        return camasSimples;
    }

    public void setCantCamasSimples(int cantCamasSimples) {
        this.camasSimples = cantCamasSimples;
        valida();
    }

    public int getCantCamasDobles() {
        return camasDobles;
    }

    public void setCantCamasDobles(int camasDobles) {
         this.camasDobles = camasDobles;
         valida ();  
    }

    public Double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(Double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }
    
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    
    public int getIdHabitacion(){
        return idHabitacion;
    }
    
     public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
    
    public void addToArrayList (Habitaciones habitacion) {
       arrayListHabitacion.add(habitacion);
    }
    
    public static ArrayList getArrayListHabitacion () {
        return arrayListHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habitaciones other = (Habitaciones) obj;
        if (this.nroHabitacion != other.nroHabitacion) {
            return false;
        }
        if (this.camasSimples != other.camasSimples) {
            return false;
        }
        if (this.camasDobles != other.camasDobles) {
            return false;
        }
        if (!Objects.equals(this.idHabitacion, other.idHabitacion)) {
            return false;
        }
        return Objects.equals(this.precioPorDia, other.precioPorDia);
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "idHabitacion=" + idHabitacion + ", nroHabitacion=" + nroHabitacion + 
                ", camasSimples=" + camasSimples + ", camasDobles=" + camasDobles + ", precioPorDia="
                + precioPorDia + "estado=" + estado + '}';
    }

  
    
}
