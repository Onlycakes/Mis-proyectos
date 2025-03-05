
package Entities;

import DAO.PasajerosDao;
import Excepciones.DuplicateEntryException;
import java.util.Objects;
import data.ConexionBDD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pasajeros {
    private Long idPasajero;
    private String nombre;
    private String apellido;
    private long dni;
    private long telefono;
    private String email;
    private int estado;

    public Pasajeros(String nombre, String apellido, long dni, long telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono; 
        this.email = email; 
    }
    
    public void save () throws DuplicateEntryException {
             
            Connection conexion = null;
        try {
            conexion = ConexionBDD.getConnection(); 
            PasajerosDao pasajerosDao = new PasajerosDao(conexion);
            String nombres= this.getNombre();
            String apellidos= this.getApellido();
            Long doc= this.getDni();
            pasajerosDao.pasajeroDuplicadoNuevo(nombres, apellidos, doc); 
            
        if (!validaDni(dni)) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos.");
        }
        if (!validaTelefono(telefono)) {
            throw new IllegalArgumentException("El teléfono debe tener 10 u 11 dígitos.");
        }
        if (!validaEmail(email)) {
            throw new IllegalArgumentException("El email debe contener '@' y terminar con '.com'.");
        }   
            pasajerosDao.save(this); 
        } catch (SQLException e) {
            
        } finally {
                try {
                    if (conexion != null && !conexion.isClosed()) {
                        conexion.close();
                    }   } catch (SQLException ex) {
                    Logger.getLogger(Habitaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
         }
    
     public void setIdPasajero(long idPasajero){
        this.idPasajero=idPasajero;
    }
     
    public Long getIdPasajero(){
        return idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
       
            this.email = email; 
   }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
   
    public boolean validaDni(long dni) {
        String dniStr = String.valueOf(dni);
        return dniStr.length() == 8;
    }

    public boolean validaTelefono(long telefono) {
        String telefonoStr = String.valueOf(telefono);
        return telefonoStr.length() == 10 || telefonoStr.length() == 11;
    }

    public boolean validaEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
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
        final Pasajeros other = (Pasajeros) obj;
        
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        
        if (this.dni != other.dni) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.idPasajero, other.idPasajero);
    }

    @Override
    public String toString() {
        return "Pasajeros{" + "idPasajero=" + idPasajero + ", nombre=" + nombre + 
                ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono + 
                ", email=" + email + "estado=" + estado + '}';
    }
    

 
    }

    