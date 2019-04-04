/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.jefedesarrollo.modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.util.Conexion;

/**
 *
 * @author Augusto Meza
 */
public class jefeDesarrollo {

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJefeDesarrollo() {
        return idJefeDesarrollo;
    }

    public void setIdJefeDesarrollo(int idJefeDesarrollo) {
        this.idJefeDesarrollo = idJefeDesarrollo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    
    private int idJefeDesarrollo;
    private int idEmpleado;
    private int idArea;
    private int idUsuario;
    public Conexion con;
    
    public void setearIdUsuario(String id){
        int idInt = Integer.parseInt(id);
        this.setIdUsuario(idInt);
    }
    
    public void obtenerIdJefeDesarrollo(){
        String query = "SELECT idJefeDesarrollo from jesfesDesarrollo where idEmpleado = " + this.idEmpleado;
    }
    
    public void obtenerIdEmpleado(){
        String query = "SELECT idEmpleado from empleados where idUsuario = " + this.getIdUsuario() ; 
        con.setRs(query);
        ResultSet rs = con.getRs();
        try {
            this.setIdEmpleado(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(jefeDesarrollo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void obtenerArea(){
        String query = "SELECT idArea from JefeDesarrollo where idEmpleado = " + this.getIdEmpleado();
        con.setRs(query);
        ResultSet rs = con.getRs();
        
        try {
            this.idArea = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(jefeDesarrollo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet obtenerSolicitudes(){
        
        String consulta = ""
                + "select solicitudes.idSolicitud, "
                + "solicitudes.detalleSolicitud, "
                + "empleados.nombresEmpleado, "
                + "empleados.apellidosEmpleado "
                + "from solicitudes "
                + "inner JOIN jefesArea on  jefesArea.idJefeArea = solicitudes.idSolicitante"
                + " INNER JOIN empleados on jefesArea.idEmpleado = empleados.idEmpleado "
                + "where empleados.areaEmpleado = 1" + this.getIdArea()+ "))";
        con.setRs(consulta);
        ResultSet rs = con.getRs();
        
        return rs;        
    }
    
   public ResultSet obtenerCasos(){       
       String consulta = "select * from casos where idSolicitudAprobada = (select idSolicitud )from estadosSolicitudes where )";
       con.setRs(consulta);
       ResultSet rs = con.getRs();
       return rs;
               
    }
    
    public ResultSet obtenerProgramadores(){
        String consulta = "select * from programadores where idJefeDesarrollo = " + this.idJefeDesarrollo;
        ResultSet rs;
        con.setRs(consulta);
        rs = con.getRs();
        return rs;
    }
   
    public ResultSet obtenerEmpleadosArea(String idSolicitud){
        String consulta = "select * from empleadosDeArea where idJefeArea = "
                + "(Select idSolicitante from solicitudes where idSolicitud = " + idSolicitud + ") " ;
        ResultSet rs;
        con.setRs(consulta);
        rs = con.getRs();
        return rs;
    }
    
    public void ingresarCaso(String query) throws SQLException{
        con.setQuery(query);
    }
    
    public void rechazarCaso(String query) throws SQLException{
        con.setQuery(query);
    }
    
    
    
    
    
    
}
