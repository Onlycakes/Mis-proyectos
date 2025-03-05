/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import Entities.Habitaciones;
import java.util.ArrayList;
/**
 *
 * @author danie
 */

public class HabitacionesTableModel extends GenericTableModel<Habitaciones> {
    
private static final String[] NOMBRE_COLUMNA = {"Id", "Simples", "Dobles", "Precio", "Numero", "1 Activo"};
    protected static ArrayList<Habitaciones> habitaciones= new ArrayList<>(); 
    
    public HabitacionesTableModel(ArrayList<Habitaciones>listadoHabitaciones) {
        
        super(listadoHabitaciones, NOMBRE_COLUMNA);
        
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Habitaciones habitacion = getFila(fila); 
        switch (columna) {
            case 0: return habitacion.getIdHabitacion();
            case 1: return habitacion.getCantCamasSimples();
            case 2: return habitacion.getCantCamasDobles();
            case 3: return habitacion.getPrecioPorDia();
            case 4: return habitacion.getNroHabitacion();
            case 5: return habitacion.getEstado();
            
            default: return null; 
        }
    }
    
    public void addList (Habitaciones habitacion) {
        habitaciones.add(habitacion);
    }

    public Habitaciones getF (int fila) {
        if (fila >= 0) {
        return habitaciones.get(fila); 
    } else {
        return null; 
    }
    }
  
    public void updateArray (int fila,Habitaciones habitacion) {
    
    habitaciones.set(fila, habitacion);
    
        fireTableRowsUpdated(fila, fila);
}

}

    

