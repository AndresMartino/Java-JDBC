package principal;

import java.util.Locale;
import java.util.Scanner;
import servicios.FabricanteServicios;
import servicios.ProductoServicios;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ProductoServicios productoServicios = new ProductoServicios();
        FabricanteServicios fabricanteServicios=new FabricanteServicios();
        int opc = 0;
        do {
            try {
                System.out.printf("%20s \n", "MENU");
                System.out.printf("1-Lista el nombre de todos los productos que hay en la tabla producto.\n");
                System.out.printf("2-Lista los nombres y los precios de todos los productos de la tabla producto.\n");
                System.out.printf("3-Listar aquellos productos que su precio esté entre 120 y 202.\n");
                System.out.printf("4-Buscar y listar todos los Portátiles de la tabla producto.\n");
                System.out.printf("5-Listar el nombre y el precio del producto más barato.\n");
                System.out.printf("6-Ingresar un producto a la base de datos.\n");
                System.out.printf("7-Ingresar un fabricante a la base de datos\n");
                System.out.printf("8-Editar un producto con datos a elección.\n");
                System.out.println("9-SALIR");
                opc = read.nextInt();
                switch (opc) {
                    case 1:
                        productoServicios.printProductos();
                        break;

                    case 2:
                        productoServicios.printProductosNombreyPrecio();
                        break;

                    case 3:
                        productoServicios.printProductosIntervalo();
                        break;

                    case 4:
                        productoServicios.printProductosPortatiles();
                        break;

                    case 5:
                        productoServicios.printProductosBarato();
                        break;

                    case 6:
                        System.out.println("Ingrese nombre del producto");
                        String nombre = read.next();
                        System.out.println("Ingrese precio producto");
                        Double precio = read.nextDouble();
                        System.out.println("Ingrese codigo de fabricante");
                        int codigoFabricante = read.nextInt();
                        productoServicios.createProducto(nombre, precio, codigoFabricante);
                        break;

                    case 7:
                        
                        System.out.println("Ingrese nombre del fabricante");
                        String nombreFab = read.next();
                        fabricanteServicios.createFabricante(nombreFab);
                        break;

                    case 8:
                        System.out.println("ingrese id a modificar");
                        int id=read.nextInt();
                        System.out.println("ingrese nuevo nombre");
                        String nombreNew=read.next();
                        System.out.println("ingrese nuevo precio");
                        Double precioNew=read.nextDouble();
                        productoServicios.modificarProducto(id, nombreNew, precioNew);
                        break;

                    case 9:
                        System.out.println("SALIENDO");
                        break;

                    default:
                        System.out.println("ERROR");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opc != 9);
    }

}
