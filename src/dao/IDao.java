package dao;

import java.util.List;

public interface IDAO<T> {
    
    //crear
    T guardar (T t);

    //consultar todos los T
    List<T> listarTodos();

    //consultar por id
    T consultarPorId(Integer id);

    //eliminar
    void eliminarPorId(Integer id);

    //actualizar
    T actualizar(T t);
}