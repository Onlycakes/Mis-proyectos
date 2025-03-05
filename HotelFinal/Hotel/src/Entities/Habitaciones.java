
package Entities;

import java.util.Objects;
public class Habitaciones {
    protected Long idHabitacion;
    protected int nroHabitacion;
    protected int camasSimples;
    protected int camasDobles;
    protected Double precioPorDia;
  

    public Habitaciones(int nroHabitacion, int cantCamasSimples, int camasDobles) {
        this.nroHabitacion = nroHabitacion;
        this.camasSimples = cantCamasSimples;
        this.setCamasDobles(camasDobles);
       //this.camasDobles = camasDobles;
    }

    public int getnroHabitacion() {
        return nroHabitacion;
    }

    public void setnroHabitacion(int idHabitacion) {
        this.nroHabitacion = idHabitacion;
    }

    public int getCantCamasSimples() {
        return camasSimples;
    }

    public void setCantCamasSimples(int cantCamasSimples) {
        this.camasSimples = cantCamasSimples;
    }

    public int getCamasDobles() {
        return camasDobles;
    }

    public void setCamasDobles(int camasDobles) {
       if (camasDobles>1 || camasDobles<0 ){
         //throw new Exception("test");
         throw new IllegalArgumentException("El máximo permitido es 1 cama doble.");/////////
       }
         this.camasDobles = camasDobles;
       
    }

    public Double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(Double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }
    public Long getIdHabitacion(){
        return idHabitacion;
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
                + precioPorDia + '}';
    }

   
    
    
}
