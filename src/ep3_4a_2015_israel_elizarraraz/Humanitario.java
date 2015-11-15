/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3_4a_2015_israel_elizarraraz;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author block_000
 */
public class Humanitario extends Voluntario{
    private String profesion;
    private boolean disponible;
    private int numTrabajos;
    GregorianCalendar fechaInicio, fechaFin;
    String lugarMision;

    public Humanitario(String profesion, boolean disponible, int numTrabajos, String curp, String nombre, String nacionalidad, int edad, String sedeIns) {
        super(curp, nombre, nacionalidad, edad, sedeIns);
        this.profesion = profesion;
        this.disponible = disponible;
        this.numTrabajos = numTrabajos;
    }
    
    public Humanitario(String profesion, boolean disponible, int numTrabajos, String curp, String nombre, String nacionalidad, int edad, String sedeIns, GregorianCalendar fecInicio, GregorianCalendar fecFin, String lugar) {
        super(curp, nombre, nacionalidad, edad, sedeIns);
        this.profesion = profesion;
        this.disponible = disponible;
        this.numTrabajos = numTrabajos;
        this.fechaInicio = fecInicio;
        this.fechaFin = fecFin;
        this.lugarMision = lugar;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setNumTrabajos(int numTrabajos) {
        this.numTrabajos = numTrabajos;
    }

    public void setFechaInicio(GregorianCalendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(GregorianCalendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setLugarMision(String lugarMision) {
        this.lugarMision = lugarMision;
    }

    
    
    @Override
    public void imprimirVoluntario() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("==================Voluntario humanitario====================");
        System.out.println("CURP: " + this.curp);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nacionalidad: " + this.nacionalidad);
        System.out.println("Edad: " + this.edad);
        System.out.println("Sede de inscripcion: " + this.sedeIns);
        System.out.println("Profesion: " + this.profesion);
        if(this.disponible)
            System.out.println("Voluntario disponible");
        else
            System.out.println("Voluntario no disponoble");
        System.out.println("Numero de trabajos: " + this.numTrabajos);
        if(fechaInicio != null) {
            System.out.println("Fecha de inicio de la mision: " + formato.format(fechaInicio.getTime()));
            System.out.println("Fecha de finalizacion de la mision: " + formato.format(fechaFin.getTime()));
            System.out.println("Lugar de la mision: " + this.lugarMision);
        }
    }
    
    
}
