package ma.enset.Dao;

import java.util.List;

public interface Dao<T> {
    T find(long id);
    void save(T o);
    void delete(T o);
    void update(T o);
    List<T> findall();

}
