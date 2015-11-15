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
public class Administrativo extends Voluntario{
    private int horarioActual, horarioDisponible; //1 = matutino, 2 = vespertino, 3 = nocturno

    public Administrativo(int horarioActual, int horarioDisponible, String curp, String nombre, String nacionalidad, int edad, String sedeIns) {
        super(curp, nombre, nacionalidad, edad, sedeIns);
        this.horarioActual = horarioActual;
        this.horarioDisponible = horarioDisponible;
    }

    public int getHorarioActual() {
        return horarioActual;
    }

    public void setHorarioActual(int horarioActual) {
        this.horarioActual = horarioActual;
    }

    public int getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(int horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }
    
    
    
    @Override
    public void imprimirVoluntario() {
        System.out.println("==================Voluntario administrativo====================");
        System.out.println("CURP: " + this.curp);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nacionalidad: " + this.nacionalidad);
        System.out.println("Edad: " + this.edad);
        System.out.println("Sede de inscripcion: " + this.sedeIns);
        switch(horarioActual) {
            case 1:
                System.out.println("Horario actual: Matutino");
                break;
            case 2:
                System.out.println("Horario actual: Vespertino");
                break;
            case 3:
                System.out.println("Horario actual: Nocturno");
                break;
        }
        switch(horarioDisponible) {
            case 1:
                System.out.println("Horario disponible: Matutino");
                break;
            case 2:
                System.out.println("Horario disponible: Vespertino");
                break;
            case 3:
                System.out.println("Horario disponible: Nocturno");
                break;
        }
    }
    
    
}
