
package Entities;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Reserva {
   protected Long idReserva; 
   protected LocalDate fechaCheckIn;
   protected LocalDate fechaCheckOut;
   protected List<Habitaciones> habitacionesReservadas;
   protected Pasajeros pasajero;
   protected Double senia;

 

    public Reserva(LocalDate fechaCheckIn, LocalDate fechaCheckOut, List<Habitaciones> habitacionesReservadas, Pasajeros pasajero, Double senia) {
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.habitacionesReservadas = habitacionesReservadas;
        this.pasajero = pasajero;
        this.senia = senia;
    }
    public Long getIdReserva(){
        return idReserva;
    }
    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public List<Habitaciones> getHabitacionesReservadas() {
        return habitacionesReservadas;
    }

    public void setHabitacionesReservadas(List<Habitaciones> habitacionesReservadas) {
        this.habitacionesReservadas = habitacionesReservadas;
    }

    public Pasajeros getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajeros pasajero) {
        this.pasajero = pasajero;
    }

    public Double getSenia() {
        return senia;
    }

    public void setSenia(Double senia) {
        this.senia = senia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.fechaCheckIn, other.fechaCheckIn)) {
            return false;
        }
        if (!Objects.equals(this.fechaCheckOut, other.fechaCheckOut)) {
            return false;
        }
        if (!Objects.equals(this.habitacionesReservadas, other.habitacionesReservadas)) {
            return false;
        }
        if (!Objects.equals(this.pasajero, other.pasajero)) {
            return false;
        }
        return Objects.equals(this.senia, other.senia);
    }

    @Override
    public String toString() {
        return "Reserva{" + "fechaCheckIn=" + fechaCheckIn + ", fechaCheckOut=" + 
                fechaCheckOut + ", habitacionesReservadas=" + habitacionesReservadas + 
                ", pasajero=" + pasajero + ", senia=" + senia + '}';
    }
    
   
    
    
}
