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
 * @author Usuario
 */
public class Empleado {

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the nombresEmpleado
     */
    public String getNombresEmpleado() {
        return nombresEmpleado;
    }

    /**
     * @param nombresEmpleado the nombresEmpleado to set
     */
    public void setNombresEmpleado(String nombresEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
    }

    /**
     * @return the apellidosEmpleado
     */
    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    /**
     * @param apellidosEmpleado the apellidosEmpleado to set
     */
    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    /**
     * @return the duiEmpleado
     */
    public String getDuiEmpleado() {
        return duiEmpleado;
    }

    /**
     * @param duiEmpleado the duiEmpleado to set
     */
    public void setDuiEmpleado(String duiEmpleado) {
        this.duiEmpleado = duiEmpleado;
    }

    /**
     * @return the fechaNacimientoEmpleado
     */
    public String getFechaNacimientoEmpleado() {
        return fechaNacimientoEmpleado;
    }

    /**
     * @param fechaNacimientoEmpleado the fechaNacimientoEmpleado to set
     */
    public void setFechaNacimientoEmpleado(String fechaNacimientoEmpleado) {
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
    }

    /**
     * @return the usuarioEmpleado
     */
    public int getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    /**
     * @param usuarioEmpleado the usuarioEmpleado to set
     */
    public void setUsuarioEmpleado(int usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    /**
     * @return the cargoEmpleado
     */
    public int getCargoEmpleado() {
        return cargoEmpleado;
    }

    /**
     * @param cargoEmpleado the cargoEmpleado to set
     */
    public void setCargoEmpleado(int cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    /**
     * @return the areaEmpleado
     */
    public int getAreaEmpleado() {
        return areaEmpleado;
    }

    /**
     * @param areaEmpleado the areaEmpleado to set
     */
    public void setAreaEmpleado(int areaEmpleado) {
        this.areaEmpleado = areaEmpleado;
    }
    private int idEmpleado;
    private String nombresEmpleado;
    private String apellidosEmpleado;
    private String duiEmpleado;
    private String fechaNacimientoEmpleado;
    private int usuarioEmpleado;
    private int cargoEmpleado;
    private int areaEmpleado;
    
    public Empleado(){
        
    }
    
    public Empleado(int idEmpleado) throws SQLException{
        Conexion con = new Conexion();
        con.setRs("SELECT * FROM empleados WHERE idEmpleado = " + idEmpleado);
        ResultSet rs = con.getRs();
        if (rs.next()) {
            idEmpleado = idEmpleado;
            String nombresEmpleado = rs.getString("nombresEmpleado");
            String apellidosEmpleado = rs.getString("apellidosEmpleado");
            String duiEmpleado = rs.getString("duiEmpleado");
            String fechaNacimientoEmpleado = rs.getString("fechaNacimientoEmpleado");
            int usuarioEmpleado = rs.getInt("usuarioEmpleado");
            int cargoEmpleado = rs.getInt("cargoEmpleado");
            int areaEmpleado = rs.getInt("areaEmpleado");

            this.idEmpleado = idEmpleado;
            this.nombresEmpleado = nombresEmpleado;
            this.apellidosEmpleado = apellidosEmpleado;
            this.duiEmpleado = duiEmpleado;
            this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
            this.usuarioEmpleado = usuarioEmpleado;
            this.cargoEmpleado = cargoEmpleado;
            this.areaEmpleado = areaEmpleado;
        }
        con.cerrarConexion();
    }
    
}
