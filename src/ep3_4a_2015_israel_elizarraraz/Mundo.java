/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3_4a_2015_israel_elizarraraz;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author block_000
 */
public class Mundo {
    private Sede sedes[];
    
    public Mundo() {
        sedes = new Sede[0];
    }
    
    public void nuevaSede(Sede sede) {
        Sede aux[] = new Sede[sedes.length+1];
        System.arraycopy(sedes, 0, aux, 0, sedes.length);
        aux[sedes.length] = sede;
        sedes = aux;
    }
    
    public void crearSede() {
        String direccion, ciudad, director;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la direccion de la sede: ");
        direccion = scan.nextLine();
        
        System.out.println("Introduzca la ciudad de la sede: ");
        ciudad = scan.nextLine();
        for(int i=0;i<sedes.length;i++) {
            if(sedes[i].getCiudad().equals(ciudad)) {
                System.out.println("La sede ya ha sido registrada");
                return;
            }
        }
        System.out.println("Introduzca el nombre del director: ");
        director = scan.nextLine();
        Sede sedeaux = new Sede(direccion,ciudad,director);
        nuevaSede(sedeaux);
    }
    
    public void nuevoVoluntario(int op) {
        Scanner scan = new Scanner(System.in);
        String sede, curp, nombre, nacionalidad;
        boolean correcto = false, disponible;
        int edad;
        
        System.out.println("Introduzca la ciudad de la sede de inscripcion del voluntario: ");
        sede = scan.nextLine();
        
       for(int i=0;i<sedes.length;i++) {
           if(sedes[i].getCiudad().equals(sede)) {
               do { 
                    System.out.println("Introduzca la CURP del voluntario");
                    curp = scan.nextLine();
                    if(curp.length() != 18) 
                        System.out.println("Error en la introduccion del CURP, intentelo de nuevo.");
                    else
                        correcto = true;
               } while(!correcto);
               
               for(int j=0;j<sedes.length;j++) {
                   for(int x=0;x<sedes[j].getVoluntarios().length;x++) {
                       if(sedes[j].getVoluntarios()[x].curp.equals(curp)) {
                           System.out.println("El voluntario ya ha sido registrado previamente");
                           return;
                       }
                   }
               }
               System.out.println("Introduzca el nombre del voluntario");
               nombre = scan.nextLine();
               System.out.println("Introduzca la nacionalidad del voluntario");
               nacionalidad = scan.nextLine();
               System.out.println("Introduzca la edad del voluntario");
               edad = scan.nextInt();
               scan.nextLine();
               if(op == 2) {
                   System.out.println("Profesion: ");
                   String profesion = scan.nextLine();
                   System.out.println("Esta disponible? [S/N]: ");
                   String dis = scan.nextLine();
                   disponible = dis.equals("S");
                   System.out.println("Numero de trabajos realizados: ");
                   int numT = scan.nextInt();
                   scan.nextLine();
                   System.out.println("Se encuentra en una mision? [S/N]");
                   String mis = scan.nextLine();
                   if(mis.equals("S")) {
                       System.out.println("Dia de inicio de la mision: ");
                       int dia = scan.nextInt();
                       System.out.println("Mes de inicio de la mision: ");
                       int mes = scan.nextInt();
                       System.out.println("Anio de inicio de la mision: ");
                       int anio = scan.nextInt();
                       GregorianCalendar fecInicio = new GregorianCalendar(anio,mes-1,dia);
                       System.out.println("Dia de finalizacion de la mision: ");
                       dia = scan.nextInt();
                       System.out.println("Mes de finalizacion de la mision: ");
                       mes = scan.nextInt();
                       System.out.println("Anio de finalizacion de la mision: ");
                       anio = scan.nextInt();
                       scan.nextLine();
                       GregorianCalendar fecFin = new GregorianCalendar(anio,mes-1,dia);
                       System.out.println("Lugar de la mision: ");
                       String lugar = scan.nextLine();
                       sedes[i].anadirVoluntario(curp, nombre, nacionalidad, edad, profesion, disponible, numT, fecInicio, fecFin, lugar);
                   }
                   else
                       sedes[i].anadirVoluntario(curp, nombre, nacionalidad, edad, profesion, disponible, numT);
               }
               if(op == 3) {
                   System.out.println("Horario actual del trabajador [1: Matutino | 2: Vespertino | 3:Nocturno]: ");
                   int horarioActual = scan.nextInt();
                   System.out.println("Horario disponible del trabajador [1: Matutino | 2: Vespertino | 3:Nocturno]: ");
                   int horarioDisponible = scan.nextInt();
                   sedes[i].anadirVoluntario(curp, nombre, nacionalidad, edad, horarioActual, horarioDisponible);
               }
               return;
           }
       }
        System.out.println("No se encontro la sede especificada");
    }
    
    public void mostrarTodo() {
        for(int i=0;i<sedes.length;i++) {
            sedes[i].imprimirSede();
        }
    }
    
    public void quitarVoluntario() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la CURP del voluntario: ");
        String curp = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                if(sedes[i].getVoluntarios()[j].curp.equals(curp)) {
                    sedes[i].eliminarVoluntario(j);
                    System.out.println("Voluntario eliminado");
                    return;
                }
            }
        }
        System.out.println("No se encontro al voluntario con la CURP  " +  curp);
    }
    
    public void quitarSede() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca la ciudad de la sede a eliminar");
        String ciudad = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            if(sedes[i].getCiudad().equals(ciudad)) {
                if(sedes[i].getVoluntarios().length>0) {
                    System.out.println("La sede tiene voluntarios registrados. Desea continuar? [S/N]: ");
                    String cont = scan.nextLine();
                    if(cont.equals("N"))
                        return;
                    else {
                        sedes[i].eliminarTodosVoluntarios();
                    }
                }
            
            Sede aux[] = new Sede[sedes.length-1];
            System.arraycopy(sedes, 0, aux, 0, i);
            System.arraycopy(sedes, i+1, aux, i, sedes.length-i-1);
            sedes = aux;
            return;
            }
        }
        System.out.println("No se encontro la sede especificada");
    }
    
    public void modificarVoluntario() { 
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la CURP del voluntario");
        String curp = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                if(sedes[i].getVoluntarios()[j].curp.equals(curp)) {
                    System.out.println("Nuevo nombre: ");
                    sedes[i].getVoluntarios()[j].setNombre(scan.nextLine());
                    System.out.println("Nueva nacionalidad: ");
                    sedes[i].getVoluntarios()[j].setNacionalidad(scan.nextLine());
                    System.out.println("Nueva edad: ");
                    sedes[i].getVoluntarios()[j].setEdad(scan.nextInt());
                    scan.nextLine();
                    
                    if(sedes[i].getVoluntarios()[j] instanceof Humanitario) {
                        System.out.println("Cambiar profesion: "); 
                        ((Humanitario)sedes[i].getVoluntarios()[j]).setProfesion(scan.nextLine());
                        System.out.println("Cambiar trabajos realizados: "); 
                        ((Humanitario)sedes[i].getVoluntarios()[j]).setNumTrabajos(scan.nextInt());
                        scan.nextLine();
                        System.out.println("El usuaro se encuentra en una mision? [S/N]: ");
                        String mis = scan.nextLine();
                        if(mis.equals("S")) {
                            System.out.println("Dia de inicio: ");
                            int dia = scan.nextInt();
                            System.out.println("Mes de inicio: ");
                            int mes = scan.nextInt();
                            System.out.println("Anio de inicio: ");
                            int anio = scan.nextInt();
                            GregorianCalendar fecInicio = new GregorianCalendar(anio,mes-1,dia);
                            ((Humanitario)sedes[i].getVoluntarios()[j]).setFechaInicio(fecInicio);
                            System.out.println("Dia de finalizacion: ");
                            dia = scan.nextInt();
                            System.out.println("Mes de finalizacion: ");
                            mes = scan.nextInt();
                            System.out.println("Anio de finalizacion: ");
                            anio = scan.nextInt();
                            GregorianCalendar fecFin = new GregorianCalendar(anio,mes-1,dia);
                            ((Humanitario)sedes[i].getVoluntarios()[j]).setFechaFin(fecFin);
                            scan.nextLine();
                            System.out.println("Lugar de la mision: ");
                            ((Humanitario)sedes[i].getVoluntarios()[j]).setLugarMision(scan.nextLine());
                        }
                    }
                    return;
                }
            }
        }
        System.out.println("No se encontro ningun voluntario registrado con esa CURP");
    }
    
    public void modificarSede() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la ciudad de la sede a modificar: ");
        String ciudad = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            if(sedes[i].getCiudad().equals(ciudad)) {
                System.out.println("Introduzca la nueva direccion de la sede: ");
                sedes[i].setDireccion(scan.nextLine());
                System.out.println("Introduzca el nombre del director: ");
                sedes[i].setDirector(scan.nextLine());
                return;
            }
        }
        
        System.out.println("No se encontro una sede dentro de la ciudad especificada");
    }
    
    public void cambiarDisponibilidad() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la CURP del voluntario");
        String curp = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                if(sedes[i].getVoluntarios()[j].curp.equals(curp)) {
                    if(sedes[i].getVoluntarios()[j] instanceof Humanitario) {
                        if(((Humanitario)sedes[i].getVoluntarios()[j]).isDisponible()) {
                            ((Humanitario)sedes[i].getVoluntarios()[j]).setDisponible(false);
                            System.out.println("Disponibilidad cambiada, el voluntario ya no esta disponible");
                        }
                        else {
                            ((Humanitario)sedes[i].getVoluntarios()[j]).setDisponible(true);
                            System.out.println("Disponibilidad cambiada, el voluntario ya esta disponible");
                        }
                    }       
                    if(sedes[i].getVoluntarios()[j] instanceof Administrativo) {
                       switch(((Administrativo)sedes[i].getVoluntarios()[j]).getHorarioActual()) {
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
                       switch(((Administrativo)sedes[i].getVoluntarios()[j]).getHorarioDisponible()) {
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
                        System.out.println("Desea cambiar el horario actual por el horario disponible? [S/N]: ");
                        String ch = scan.nextLine();
                        
                        if(ch.equals("S")) {
                            ((Administrativo)sedes[i].getVoluntarios()[j]).setHorarioActual(((Administrativo)sedes[i].getVoluntarios()[j]).getHorarioDisponible());
                            System.out.println("Nueva disponibilidad de horario [1 = Matutino | 2 = Vespertino | 3 = Nocturno]");
                            ((Administrativo)sedes[i].getVoluntarios()[j]).setHorarioDisponible(scan.nextInt());
                        }
                        else
                            return;
                    }
                }
            }
        }
    }
    
    public void consultarCURP() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca el CURP del voluntario");
        String curp = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                if(sedes[i].getVoluntarios()[j].curp.equals(curp)) {
                    sedes[i].getVoluntarios()[j].imprimirVoluntario();
                }
            }
        }
        
    }
    
    public void consultarPorSede() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la ciudad de la sede para ver a los voluntarios");
        String ciudad = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            if(sedes[i].getCiudad().equals(ciudad))
                sedes[i].imprimirVolunSede();
        }
    }
    
    public void consultarPorDisp() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("1.-Humanitarios\n2.-Administrativos");
        int op = scan.nextInt();
        if(op == 1) {
            System.out.println("1.-Ver todos los voluntarios disponibles\n2.-Ver todos los voluntarios no disponibles");
            int op2 = scan.nextInt();
            if(op2 == 1) {
                for(int i=0;i<sedes.length;i++) {
                    for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                        if(sedes[i].getVoluntarios()[j] instanceof Humanitario) {
                            if(((Humanitario)sedes[i].getVoluntarios()[j]).isDisponible()) {
                                sedes[i].getVoluntarios()[j].imprimirVoluntario();
                            }
                        }
                    }
                }
            }
            if(op2 == 2) {
                for(int i=0;i<sedes.length;i++) {
                    for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                        if(sedes[i].getVoluntarios()[j] instanceof Humanitario) {
                            if(!((Humanitario)sedes[i].getVoluntarios()[j]).isDisponible()) {
                                sedes[i].getVoluntarios()[j].imprimirVoluntario();
                            }
                        }
                    }
                }
            }
                
        }
        if(op == 2) {
            System.out.println("1.-Administrativos de horario matutino\n2.-Administrativos de horario vespertino\n3.-Administrativos de horario nocturno\n");
            int op2 = scan.nextInt();
            
            switch(op2) {
                case 1:
                   for(int i=0;i<sedes.length;i++) {
                        for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                            if(sedes[i].getVoluntarios()[j] instanceof Administrativo) {
                                if(((Administrativo)sedes[i].getVoluntarios()[j]).getHorarioActual() == 1) {
                                    sedes[i].getVoluntarios()[j].imprimirVoluntario();
                                }
                            }
                        }                
                    } 
                break;
                case 2:
                   for(int i=0;i<sedes.length;i++) {
                        for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                            if(sedes[i].getVoluntarios()[j] instanceof Administrativo) {
                                if(((Administrativo)sedes[i].getVoluntarios()[j]).getHorarioActual() == 2) {
                                    sedes[i].getVoluntarios()[j].imprimirVoluntario();
                                }
                            }
                        }                
                    } 
                break;
                case 3:
                   for(int i=0;i<sedes.length;i++) {
                        for(int j=0;j<sedes[i].getVoluntarios().length;j++) {
                            if(sedes[i].getVoluntarios()[j] instanceof Administrativo) {
                                if(((Administrativo)sedes[i].getVoluntarios()[j]).getHorarioActual() == 3) {
                                    sedes[i].getVoluntarios()[j].imprimirVoluntario();
                                }
                            }
                        }                
                    } 
                break;
            }
        }
    }
    
    public void consultarSede() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca la ciudad de la sede: "); 
        String ciudad = scan.nextLine();
        
        for(int i=0;i<sedes.length;i++) {
            if(sedes[i].getCiudad().equals(ciudad)) {
                sedes[i].imprimirSede();
            }
        }
    }
}

