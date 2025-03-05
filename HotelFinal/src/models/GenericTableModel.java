/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author danie
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;;

public class GenericTableModel<T> extends AbstractTableModel {
    private ArrayList<T> objetos;        
    private String[] nombreColumnas;

    public GenericTableModel(ArrayList<T> objeto, String[] nombreColumnas) {
        this.objetos = objeto;
        this.nombreColumnas = nombreColumnas;
    }

    @Override
    public int getRowCount() {
        return objetos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length; 
    }

    @Override
    public String getColumnName(int columnas) {
        return nombreColumnas[columnas]; 
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        return null;
    }

    public T getFila(int fila) {
        return objetos.get(fila);
    }
    
    public void removeFila(int fila) {
        objetos.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }
   
    public void addFila(T obj) {
        objetos.add(obj);
        int fila = objetos.size() - 1;
        fireTableRowsInserted(fila, fila);
        
    }
 
    public ArrayList<T> objetos (){
     return objetos;
     
}
    public void updateFila(int fila, T obj) {
        objetos.set(fila, obj);
        fireTableRowsUpdated(fila, fila);
    }
}
