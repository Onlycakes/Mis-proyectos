
package Entities;

import java.util.List;
import Excepciones.DuplicateEntryException;
import Excepciones.NotFoundException;

public interface Dao<T> {
    public abstract void save(T data) throws DuplicateEntryException;
    public abstract T getById(int id) throws NotFoundException;
    public abstract List<T> listAll();
    public abstract void update(T data);
    public abstract void delete(T data);
}
