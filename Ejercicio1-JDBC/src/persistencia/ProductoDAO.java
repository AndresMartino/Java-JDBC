package persistencia;

import entidad.Fabricante;
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
            String sql = String.format(template, producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigoFabricante());

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
            String template = "UPDATE producto SET nombre='%s', precio='%s' WHERE codigo='%s';";
            String sql = String.format(template, producto.getNombre(), producto.getPrecio(),producto.getCodigo());

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
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo;";

            queryDatabase(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto = null;
            Fabricante fabricante=null;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante =new Fabricante();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                
                fabricante.setCodigoFabricante(resultSet.getInt(5));
                fabricante.setNombreFabricante(resultSet.getString(6));
                producto.setFabricante(fabricante);
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

    public List<Producto> intervaloPrecio() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo WHERE precio >=120 AND precio <=202 ;";

            queryDatabase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto=null;
            Fabricante fabricante=null;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante=new Fabricante();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                
                fabricante.setCodigoFabricante(resultSet.getInt(5));
                fabricante.setNombreFabricante(resultSet.getString(6));
                producto.setFabricante(fabricante);
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

    public List<Producto> buscarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo WHERE producto.nombre LIKE '%Portatil%';";
            queryDatabase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto=null;
            Fabricante fabricante=null;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante=new Fabricante();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                
                fabricante.setCodigoFabricante(resultSet.getInt(5));
                fabricante.setNombreFabricante(resultSet.getString(6));
                producto.setFabricante(fabricante);
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

    public List<Producto> productoMasBarato() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo order by precio asc limit 1;";
            queryDatabase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto=null;
            Fabricante fabricante=null;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante=new Fabricante();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                
                fabricante.setCodigoFabricante(resultSet.getInt(5));
                fabricante.setNombreFabricante(resultSet.getString(6));
                producto.setFabricante(fabricante);
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
