package servicios;

import entidad.Fabricante;
import entidad.Producto;
import java.util.List;
import persistencia.ProductoDAO;

public class ProductoServicios {

    private ProductoDAO productoDAO;

    public ProductoServicios() {
        productoDAO = new ProductoDAO();
    }

    public void createProducto(String nombre, Double precio, Fabricante fabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }
            if (precio == null || nombre.trim().isEmpty()) {
                throw new Exception("El precio es obligatorio");
            }
            if (fabricante == null || nombre.trim().isEmpty()) {
                throw new Exception("El codigo del fabricante es obligatorio");
            }

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFabricante(fabricante);

            productoDAO.crear(producto);
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
                System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", "ID", "Nombre", "Precio", "codigoFabricante","nombreFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-35s%-20s%-20s%-10s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigoFabricante(),producto.getFabricante().getNombreFabricante());

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
                System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", "ID", "Nombre", "Precio", "codigoFabricante","nombreFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigoFabricante(),producto.getFabricante().getNombreFabricante());

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
                 System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", "ID", "Nombre", "Precio", "codigoFabricante","nombreFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigoFabricante(),producto.getFabricante().getNombreFabricante());
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
                 System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", "ID", "Nombre", "Precio", "codigoFabricante","nombreFabricante");
                for (Producto producto : productos) {
                    System.out.printf("%-10s%-35s%-15s%-20s%-10s\n", producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigoFabricante(),producto.getFabricante().getNombreFabricante());
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(int id, String nombre, Double precio) throws Exception {
        boolean band=false;
        try {
            List<Producto> productos = productoDAO.getProducto();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                for (Producto producto : productos) {
                    if (producto.getCodigo() == id) {
                        producto.setNombre(nombre);
                        producto.setPrecio(precio);
                        productoDAO.modificar(producto);
                        band=true;
                        break;
                    }
                    
                }
                if (!band) {
                    System.out.println("ERROR no existe producto");
                }
            }

            

            
        } catch (Exception e) {
            throw e;

        }

    }
}
