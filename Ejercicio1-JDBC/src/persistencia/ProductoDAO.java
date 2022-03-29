package persistencia;

import entidad.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO extends DAO {

    public void saveProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("No puede no haber productos");
            }
            String template = "INSERT INTO producto VALUES(null,'%s','%s','%s');";
            String sql = String.format(template, producto.getNombre(), producto.getPrecio(), producto.getCodigoFabricante());

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al guardar producto");
        }

    }

    public void modifyProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("No puede no haber productos");
            }
            String template = "UPDATE producto SET nombre='%s', precio=%s WHERE codigo=%s";
            String sql = String.format(template, producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCodigoFabricante());;

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al modificar producto");
        }

    }

    public void deleteProducto(Integer productoId) throws Exception {
        try {

            String sql = "DELETE FROM producto WHERE codigo = " + productoId;
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al eliminar producto");
        }

    }

    public List<Producto> getProducto() throws Exception {
        try {
            String sql = "SELECT * FROM producto;";

            queryDatabase(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                producto.setCodigoFabricante(resultSet.getInt(4));
                
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al obtener productos");
        } finally {
            disconnectDatabase();

        }

    }
}
