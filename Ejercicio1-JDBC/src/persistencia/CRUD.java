package persistencia;

import java.util.List;

public interface CRUD<T, ID> {
    void crear(T entidad);
    void modificar(T entidad);
    void borrarPorId(ID id);
    T buscarPorId(ID id);
    List<T> buscarTodos();
    
}
