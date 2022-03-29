package servicios;

import entidad.Fabricante;
import entidad.Producto;
import java.util.List;
import persistencia.FabricanteDAO;
import persistencia.ProductoDAO;

public class FabricanteServicios {
    
    private FabricanteDAO fabricanteDAO;

    public FabricanteServicios() {
        fabricanteDAO = new FabricanteDAO();
    }

    public void createFabricante(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }
            

            Fabricante fabricante = new Fabricante();
            fabricante.setNombreFabricante(nombre);
           
            fabricanteDAO.saveFabricante(fabricante);
        } catch (Exception e) {
            throw e;

        }

    }

    public void printFabricantes() throws Exception {
        try {
            List<Fabricante> fabricantes = fabricanteDAO.getFabricante();
            if (fabricantes.isEmpty()) {
                throw new Exception("No existe productos");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s\n", "ID", "Nombre");
                for (Fabricante fabricante : fabricantes) {
                    System.out.printf("%-10s%-35s\n", fabricante.getCodigoFabricante(), fabricante.getNombreFabricante());

                }
            }
        } catch (Exception e) {
            throw e;

        }
    }
    public void modifyProductoPorID(int id)throws Exception{
        String sql="SELECT * FROM producto WHERE codigo= "+id+"";
        
    }
    
}
