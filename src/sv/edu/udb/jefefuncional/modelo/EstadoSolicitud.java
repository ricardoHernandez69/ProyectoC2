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
 * @author usuario
 */
public class EstadoSolicitud {

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
     * @return the estadoSolicitud
     */
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    /**
     * @param estadoSolicitud the estadoSolicitud to set
     */
    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    /**
     * @return the detalleEstadoSolicitud
     */
    public String getDetalleEstadoSolicitud() {
        return detalleEstadoSolicitud;
    }

    /**
     * @param detalleEstadoSolicitud the detalleEstadoSolicitud to set
     */
    public void setDetalleEstadoSolicitud(String detalleEstadoSolicitud) {
        this.detalleEstadoSolicitud = detalleEstadoSolicitud;
    }

    /**
     * @return the nombreRevisor
     */
    public String getNombreRevisor() {
        return nombreRevisor;
    }

    /**
     * @param nombreRevisor the nombreRevisor to set
     */
    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }
    
    private int idSolicitud;
    private String detalleSolicitud;
    private String estadoSolicitud;
    private String detalleEstadoSolicitud;
    private String nombreRevisor;
    
    public EstadoSolicitud(){
        
    }
    
    public EstadoSolicitud(int idSolicitud) throws SQLException{
        Conexion con = new Conexion();
        con.setRs("SELECT detalleSolicitud, estadoSolicitud, detalleEstadoSolicitud, empleados.nombresEmpleado AS nombresRevisor FROM solicitudes JOIN estadoSolicitudes ON solicitudes.idSolicitud = estadoSolicitudes.idSolicitud JOIN jefesDesarrollo ON estadoSolicitudes.idRevisor = jefesDesarrollo.idJefeDesarrollo JOIN empleados ON empleados.idEmpleado = jefesDesarrollo.idEmpleado WHERE solicitudes.idSolicitud = " + idSolicitud);
        ResultSet rs = con.getRs();
        
        if(rs.next()){
            String detalleSolicitud = rs.getString("detalleSolicitud");
            String estadoSolicitud = rs.getString("estadoSolicitud");
            String detalleEstadoSolicitud = rs.getString("detalleEstadoSolicitud");
            String nombreRevisor = rs.getString("nombresRevisor");
            
            this.detalleSolicitud = detalleSolicitud;
            this.estadoSolicitud = estadoSolicitud;
            this.detalleEstadoSolicitud = detalleEstadoSolicitud;
            this.nombreRevisor = nombreRevisor;
            
            System.out.println(this.detalleSolicitud);
        }
        con.cerrarConexion();
    }
    
}
