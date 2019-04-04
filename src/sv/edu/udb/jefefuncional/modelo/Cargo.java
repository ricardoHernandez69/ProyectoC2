/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.jefefuncional.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.util.Conexion;

/**
 *
 * @author Raul
 */
public class Cargo {

    /**
     * @return the idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * @return the nombreCargo
     */
    public String getNombreCargo() {
        return nombreCargo;
    }

    /**
     * @param nombreCargo the nombreCargo to set
     */
    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
    private int idCargo;
    private String nombreCargo;
    
    public Cargo(){
        
    }
    
    public Cargo(int idCargo) throws SQLException{
        Conexion con = new Conexion();
        con.setRs("SELECT idCargo, nombreCargo FROM cargos WHERE idCargo = " + idCargo);
        ResultSet rs = con.getRs();
        if (rs.next()) {
            String nombreCargo = rs.getString("nombreCargo");
            
            this.idCargo = idCargo;
            this.nombreCargo = nombreCargo;
        }
        con.cerrarConexion();
    }
}
