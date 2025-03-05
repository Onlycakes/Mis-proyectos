/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;
import java.util.List;
import Excepciones.DuplicateEntryException;
import Excepciones.NotFoundException;

/**
 *
 * @author danie
 */

public interface Dao<T> {
    public abstract void save(T data) throws DuplicateEntryException;
    public abstract T getById(int id) throws NotFoundException;
    public abstract List<T> listAll();
    public abstract void update (T data, int id) throws NotFoundException;
    public abstract void delete(T data);
}
