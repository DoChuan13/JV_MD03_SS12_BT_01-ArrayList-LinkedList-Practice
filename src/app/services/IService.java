package app.services;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    E save(E e);

    E findById(int id);

    void findByName(String name);

    E delete(int id);
}
