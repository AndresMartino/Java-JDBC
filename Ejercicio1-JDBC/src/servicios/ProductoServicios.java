package servicios;

import entidad.Producto;
import java.util.List;
import persistencia.ProductoDAO;

public class ProductoServicios {

    private ProductoDAO productoDAO;

    public ProductoServicios() {
        productoDAO = new ProductoDAO();
    }

    public void createProducto(String nombre, Double precio, Integer codigoFabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }
            if (precio == null || nombre.trim().isEmpty()) {
                throw new Exception("El precio es obligatorio");
            }
            if (codigoFabricante == null || nombre.trim().isEmpty()) {
                throw new Exception("El codigo del fabricante es obligatorio");
            }

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            productoDAO.saveProducto(producto);
        } catch (Exception e) {
            throw e;

        }

    }

    public void printProductos() throws Exception {
        try {
            List<Producto> productos = productoDAO.getProducto();
            if (productos.isEmpty()) {
                throw new Exception("No existe productos");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-15s%-20s\n", "ID", "Nombre", "Precio", "codigoFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-35s%-15s%-20s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCodigoFabricante());

                }
            }
        } catch (Exception e) {
            throw e;

        }
    }

    public void printProductosNombreyPrecio() throws Exception {
        try {
            List<Producto> productos = productoDAO.getProducto();
            if (productos.isEmpty()) {
                throw new Exception("No existe productos");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-35s%-35s\n", "Nombre", "Precio");
                for (Producto producto : productos) {
                    System.out.printf("%-35s%-35s\n", producto.getNombre(), producto.getPrecio());

                }
            }
        } catch (Exception e) {
            throw e;

        }
    }

    public void printProductosIntervalo() throws Exception {
        try {
            List<Producto> productos = productoDAO.intervaloPrecio();
            if (productos.isEmpty()) {
                throw new Exception("No existe productos");
            } else {

                System.out.println("Lista de productos");
                 System.out.printf("%-10s%-35s%-15s%-20s\n", "ID", "Nombre", "Precio", "codigoFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-35s%-15s%-20s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCodigoFabricante());

                }
            }
        } catch (Exception e) {
            throw e;

        }
    }

    public void printProductosPortatiles() throws Exception {
         try {
            List<Producto> productos = productoDAO.buscarPortatiles();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("Lista de portatiles\n");
                System.out.printf("%-10s%-40s%-20s%-20s\n","codigo","nombre", "precio","codigoFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-40s%-20s%-20s\n",producto.getCodigo(),producto.getNombre(),producto.getPrecio(),producto.getCodigoFabricante());
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void printProductosBarato() throws Exception {
         try {
            List<Producto> productos = productoDAO.productoMasBarato();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("Lista de portatiles\n");
                System.out.printf("%-10s%-40s%-20s%-20s\n","codigo","nombre", "precio","codigoFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-40s%-20s%-20s\n",producto.getCodigo(),producto.getNombre(),producto.getPrecio(),producto.getCodigoFabricante());
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
}
    