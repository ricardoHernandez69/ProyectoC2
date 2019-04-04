/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.empleadodesarrollo.modelo;

/**
 *
 * @author RodolfoEspadero
 */
public class empProgramador {
    private int idProgramador;
    private int idEmpleadoProg;
    private int idJefeDesarrollo;

    public empProgramador() {
    }

    public int getIdProgramador() {
        return idProgramador;
    }

    public void setIdProgramador(int idProgramador) {
        this.idProgramador = idProgramador;
    }

    public int getIdEmpleadoProg() {
        return idEmpleadoProg;
    }

    public void setIdEmpleadoProg(int idEmpleadoProg) {
        this.idEmpleadoProg = idEmpleadoProg;
    }

    public int getIdJefeDesarrollo() {
        return idJefeDesarrollo;
    }

    public void setIdJefeDesarrollo(int idJefeDesarrollo) {
        this.idJefeDesarrollo = idJefeDesarrollo;
    }
}
