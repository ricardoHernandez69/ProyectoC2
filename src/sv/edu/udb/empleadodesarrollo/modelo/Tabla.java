/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.empleadodesarrollo.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.util.Conexion;
import sv.edu.udb.util.Sesion;

/**
 *
 * @author RodolfoEspadero
 */
public class Tabla {

    Object[][] dta;
    DefaultTableModel modelo1;
    String[] col;
    ResultSet rs;
    Conexion con;
    Sesion sesion;

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Object[][] getDta() {
        return dta;
    }

    public void setCon(Conexion con) {
        try {
            this.con = new Conexion();
        } catch (Exception e) {
        }
    }

    public void setDta(Object[][] dta) {
        this.dta = dta;
    }

    public String[] getCol() {
        return col;
    }

    public void setCol(String[] col) {
        this.col = col;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRsCaso(String user) {
        try {
            String sql = "SELECT c.codigoCaso, c.descripcionCaso, ec.detalleElementoCaso, c.fechaLimite "
                    + "FROM caso c, elementosCaso ec "
                    + "WHERE c.idCaso = ec.idCaso "
                    + "AND c.programadorAsignado = '" + user + "';";

            con.setRs(sql);
            this.rs = con.getRs();
        } catch (Exception e) {
        }
    }
    
    public void setRsCaso(String user, String val) {
        try {
            String sql = "SELECT c.codigoCaso, c.descripcionCaso, ec.detalleElementoCaso, c.fechaLimite "
                    + "FROM caso c, elementosCaso ec "
                    + "WHERE c.idCaso = ec.idCaso "
                    + "AND c.programadorAsignado = '" + user + "' "
                    + "LIKE = '%" + val + "%';";

            con.setRs(sql);
            this.rs = con.getRs();
        } catch (Exception e) {
        }
    }

    public DefaultTableModel generarLista() throws SQLException {
        while (rs.next()) {
            String[] fil = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
            modelo1.addRow(fil);
        }
        rs.close();
        return this.modelo1;
    }
}
