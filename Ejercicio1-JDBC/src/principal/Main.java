package principal;

import java.util.Locale;
import java.util.Scanner;
import servicios.ProductoServicios;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ProductoServicios productoServicios=new ProductoServicios();
        
        try{
        productoServicios.printProductos();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
