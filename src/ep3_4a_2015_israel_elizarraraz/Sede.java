/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3_4a_2015_israel_elizarraraz;

import java.util.GregorianCalendar;

/**
 *
 * @author block_000
 */
public class Sede {
    private String direccion, ciudad, director;
    private Voluntario voluntarios[];

    public Sede(String direccion, String ciudad, String director) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.director = director;
        voluntarios = new Voluntario[0];
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Voluntario[] getVoluntarios() {
        return voluntarios;
    }
    
    
    
    //Voluntario humanitario sin mision
    public void anadirVoluntario(String curp, String nombre, String nacionalidad, int edad, String profesion, boolean disponible, int numTrabajos) {
        Voluntario aux[] = new Voluntario[voluntarios.length+1];
        System.arraycopy(voluntarios, 0, aux, 0, voluntarios.length);
        Humanitario volun = new Humanitario(profesion, disponible, numTrabajos, curp, nombre, nacionalidad,edad, this.ciudad);
        aux[voluntarios.length] = volun;
        voluntarios = aux;              
    }
    
    //Voluntario humanitario con mision
    public void anadirVoluntario(String curp, String nombre, String nacionalidad, int edad, String profesion, boolean disponible, int numTrabajos, GregorianCalendar fecInicio, GregorianCalendar fecFin, String lugar) {
        Voluntario aux[] = new Voluntario[voluntarios.length+1];
        System.arraycopy(voluntarios, 0, aux, 0, voluntarios.length);
        Humanitario volun = new Humanitario(profesion, disponible, numTrabajos, curp, nombre, nacionalidad,edad, this.ciudad, fecInicio, fecFin, lugar);
        aux[voluntarios.length] = volun;
        voluntarios = aux;              
    }
    
    //Voluntario administrativo
    public void anadirVoluntario(String curp, String nombre, String nacionalidad, int edad, int horarioActual, int horarioDisponible) {
        Voluntario aux[] = new Voluntario[voluntarios.length+1];
        System.arraycopy(voluntarios, 0, aux, 0, voluntarios.length);
        Administrativo volun = new Administrativo(horarioActual, horarioDisponible, curp, nombre, nacionalidad, edad, this.ciudad);
        aux[voluntarios.length] = volun;
        voluntarios = aux;              
    }
    
    public void imprimirSede() {
        System.out.println("*****************************************************");
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Ciudad: " + this.ciudad);
        System.out.println("Director: " + this.director);
        System.out.println("+++++++++Voluntarios registrados: " + voluntarios.length + " ++++++++++++");
        for(int i=0;i<voluntarios.length;i++) {
            voluntarios[i].imprimirVoluntario();
        }
    }
    
    public void imprimirVolunSede() {
        System.out.println("Voluntarios inscritos en sede " + this.ciudad);
        for(int i=0;i<voluntarios.length;i++) {
            voluntarios[i].imprimirVoluntario();
        }
    }
    
    public void eliminarVoluntario(int ind) {        
        if(ind>=0) {
            Voluntario aux[] = new Voluntario[voluntarios.length-1];
            System.arraycopy(voluntarios, 0, aux, 0, ind);
            System.arraycopy(voluntarios, ind+1, aux, ind, voluntarios.length - ind-1);
            voluntarios = aux;
        }
    }
    
    public void eliminarTodosVoluntarios() { voluntarios  = null; }
    
    
}
