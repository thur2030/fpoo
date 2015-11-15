/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3_4a_2015_israel_elizarraraz;

import java.util.Scanner;

/**
 *
 * @author block_000
 */
public class EP3_4A_2015_Israel_Elizarraraz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mundo mundo1 = new Mundo();
        imprimirMenu(mundo1);
    }
    
    public static void imprimirMenu(Mundo mundo1) {
        int op;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("1.-Agregar sede\n2.-Agregar voluntario humanitario\n3.-Agregar voluntatio administrativo\n4.-Eliminar voluntario\n5.-Eliminar sede\n6.-Modificar voluntario\n7.-Modificar sede\n8.-Cambiar disponibilidad\n9.-Consultar voluntario\n10.-Consultar sede\n11.-Mostrar todo\n12.-Salir");
            op = scan.nextInt();

            switch(op) {
                case 1:
                    mundo1.crearSede();
                    break;
                case 2:
                case 3:
                    mundo1.nuevoVoluntario(op);
                    break;
                case 4:
                    mundo1.quitarVoluntario();
                    break;
                case 5:
                    mundo1.quitarSede();
                    break;
                case 6:
                    mundo1.modificarVoluntario();
                    break;
                case 7:
                    mundo1.modificarSede();
                    break;
                case 8:
                    mundo1.cambiarDisponibilidad();
                    break;
                case 9:
                    System.out.println("1.-Por CURP\n2.-Por sede\n3.-Por disponibilidad");
                    int op2 = scan.nextInt();
                    switch(op2) {
                        case 1:
                            mundo1.consultarCURP();
                            break;
                        case 2:
                            mundo1.consultarPorSede();
                            break;
                        case 3:
                            mundo1.consultarPorDisp();
                            break;
                    }
                    break;
                case 10:
                    mundo1.consultarSede();
                    break;
                case 11:
                    mundo1.mostrarTodo();
                    break;
            }
        } while(op != 12);
    }
    
}
