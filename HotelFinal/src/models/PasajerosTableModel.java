/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import Entities.Pasajeros;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class PasajerosTableModel extends GenericTableModel<Pasajeros> {
    
private static final String[] NOMBRE_COLUMNA = {"Id", "Nombres", "Apellidos", "Documento", "Telefono", "Email", "1 activo"};
    protected static ArrayList<Pasajeros> pasajeros= new ArrayList<>(); 
    
    public PasajerosTableModel(ArrayList<Pasajeros>pasajeros) {
        
        super(pasajeros, NOMBRE_COLUMNA);
        
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Pasajeros pasajero = getFila(fila); 
        switch (columna) {
            case 0: return pasajero.getIdPasajero();
            case 1: return pasajero.getNombre();
            case 2: return pasajero.getApellido();
            case 3: return pasajero.getDni();
            case 4: return pasajero.getTelefono();
            case 5: return pasajero.getEmail();
            case 6: return pasajero.getEstado();
            default: return null; 
        }
    }
  
     public void addList (Pasajeros pasajero) {
        pasajeros.add(pasajero);
    }

    public Pasajeros getF (int fila) {
        if (fila >= 0) {
        return pasajeros.get(fila); 
    } else {
        return null; 
    }
    }
  
    public void updateArray (int fila, Pasajeros pasajero) {
    
    pasajeros.set(fila, pasajero);
    
        fireTableRowsUpdated(fila, fila);
}

}

