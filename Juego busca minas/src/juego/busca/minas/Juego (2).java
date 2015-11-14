/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.Scanner;

/**
 *
 * @author Maikol 
 */
public class Juego {
    private Tablero T;
    private Scanner leerDato;
    
    
    public Juego(){
        T = new Tablero();
        leerDato = new Scanner(System.in);
    }
    public void menu(){
        for(;;){
            System.out.println("===========================");
            System.out.println("   JUEGO BUCAS MINAS       ");
            System.out.println("===========================");
            System.out.println("JUGAR...................[1]");
            System.out.println("SALIR...................[2]");
            System.out.println("===========================");
            System.out.println("Elige la opcion");
            System.out.println("===========================");
            int opcion = leerDato.nextInt();
            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }
    public void jugar(){
        
    }
}
