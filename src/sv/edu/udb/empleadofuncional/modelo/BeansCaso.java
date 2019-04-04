/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.empleadofuncional.modelo;

/**
 *
 * @author Ricardo
 */
public class BeansCaso {

    public String getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(String codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public String getDescripcionCaso() {
        return descripcionCaso;
    }

    public void setDescripcionCaso(String descripcionCaso) {
        this.descripcionCaso = descripcionCaso;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getProgramadorAsignado() {
        return programadorAsignado;
    }

    public void setProgramadorAsignado(String programadorAsignado) {
        this.programadorAsignado = programadorAsignado;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }
    private String codigoCaso;
    private String descripcionCaso;
    private String fechaLimite;
    private String programadorAsignado;
    private String estadoSolicitud;
}
