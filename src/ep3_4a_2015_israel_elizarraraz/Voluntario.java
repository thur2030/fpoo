/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3_4a_2015_israel_elizarraraz;

/**
 *
 * @author block_000
 */
public class Voluntario {
    protected String curp, nombre, nacionalidad;
    protected int edad;
    protected String sedeIns;

    public Voluntario(String curp, String nombre, String nacionalidad, int edad, String sedeIns) {
        this.curp = curp;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sedeIns = sedeIns;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    
    
    public void imprimirVoluntario() {
        System.out.println("CURP: " + this.curp);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nacionalidad: " + this.nacionalidad);
        System.out.println("Edad: " + this.edad);
        System.out.println("Sede de inscripcion: " + this.sedeIns);
    }
    
    
}


