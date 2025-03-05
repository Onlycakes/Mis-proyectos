
package Entities;
import java.time.LocalDate;
import java.util.Objects;


public class Pasajeros {
    protected Long idPasajero;
    protected String nombre;
    protected String apellido;
    protected long dni;
    protected long telefono;
    protected String correo;

    public Pasajeros(String nombre, String apellido, long dni, long telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        if (this.dni != other.dni) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return Objects.equals(this.idPasajero, other.idPasajero);
    }

    @Override
    public String toString() {
        return "Pasajeros{" + "idPasajero=" + idPasajero + ", nombre=" + nombre + 
                ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono + 
                ", correo=" + correo + '}';
    }
    

 
    }

    