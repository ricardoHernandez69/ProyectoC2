/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.jefefuncional.modelo;

import java.sql.*;
import sv.edu.udb.util.Conexion;

/**
 *
 * @author Raul
 */
public class Solicitud {

    /**
     * @return the idSolicitud
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * @param idSolicitud the idSolicitud to set
     */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    /**
     * @return the detalleSolicitud
     */
    public String getDetalleSolicitud() {
        return detalleSolicitud;
    }

    /**
     * @param detalleSolicitud the detalleSolicitud to set
     */
    public void setDetalleSolicitud(String detalleSolicitud) {
        this.detalleSolicitud = detalleSolicitud;
    }

    /**
     * @return the idSolicitante
     */
    public int getIdSolicitante() {
        return idSolicitante;
    }

    /**
     * @param idSolicitante the idSolicitante to set
     */
    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }
    private int idSolicitud;
    private String detalleSolicitud;
    private int idSolicitante;
    
    public Solicitud(){
        
    }
    
    public void getSolicitud(int idSolicitud) throws SQLException{
        Conexion con = new Conexion();
        con.setRs("SELECT * FROM solicitudes WHERE idSolicitud = " + idSolicitud);
        ResultSet rs = con.getRs();
        if (rs.next()) {
            String detalleSolicitud = rs.getString("detalleSolicitud");
            int idSolicitante = rs.getInt("idSolicitante");
        }
        con.cerrarConexion();
    }
    
    public void insertarSolicitud() throws SQLException{
        Conexion con = new Conexion();
        con.setQuery("INSERT INTO solicitudes(detalleSolicitud, idSolicitante) VALUES('" + detalleSolicitud + "', " + idSolicitante + ")");
        con.cerrarConexion();
    }
}
