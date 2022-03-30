/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Fabricante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrelo
 */
public class FabricanteDAO extends DAO {

    public void saveFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("No puede no haber fabricantes");
            }
            String template = "INSERT INTO fabricante VALUES(null,'%s');";
            String sql = String.format(template, fabricante.getNombreFabricante());

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al guardar fabricante");
        }

    }

    public void modifyFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("No puede no haber productos");
            }
            String template = "UPDATE producto SET nombre='%s' WHERE codigo='%s'";
            String sql = String.format(template, fabricante.getNombreFabricante(),fabricante.getCodigoFabricante());

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al modificar fabricante");
        }

    }

    public void deleteFabricante(Integer fabricanteId) throws Exception {
        try {

            String sql = "DELETE FROM producto WHERE codigo = " + fabricanteId+";";
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al eliminar fabricante");
        }

    }

    public List<Fabricante> getFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante;";

            queryDatabase(sql);

            List<Fabricante> fabricantes = new ArrayList<>();
            Fabricante fabricante = null;

            while (resultSet.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigoFabricante(resultSet.getInt(1));
                fabricante.setNombreFabricante(resultSet.getString(2));

                fabricantes.add(fabricante);
            }
            return fabricantes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al obtener fabricantes");
        } finally {
            disconnectDatabase();

        }

    }
}
