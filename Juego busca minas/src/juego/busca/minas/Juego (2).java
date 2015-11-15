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
 //la clase Juego
public class Juego {
    private Tablero T;//hago refencia al tablero
    private Scanner leerDato;
    
    public Juego(){
        T = new Tablero();//creo un objetivo tablero
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
    }//mi menu de opciones
    
    public void jugar(){
        //System.out.pritln("Nombre del Jugador: ");
        T.llenarTablero();
        T.mostrarTablero();
        int fila, columna = 0;
        int aciertos = 0;
        int objetivo = T.cantidadCasillerosSinMinas();
        boolean salir = false;
        System.out.println("cantidad de casilleros sin minas:" +T.cantidadCasillerosSinMinas());
        do{
            System.out.println("Elige un casillero : ");
            System.out.println("Ingresando sus coordenadas");
            System.out.println("FILA: ");
            fila = leerDato.nextInt();
            System.out.println("El casillero elegido es: casillero[" + fila + "][" + columna + "]");
            //si alvoltear una mina entonces voy a poder continuar con el juego
            if(T.voltearCasillero(fila, columna)){
                ////vuelvo a mostrar el tablero actualizado
            
                T.mostrarTablero();
                //como continua con el juego
                //=> incremento el numero de aciertos
                aciertos++;
                System.out.println("aciertos: "+ aciertos);
                //cuando acierto sea igual que la cantidad de casilleros sin minas que es el objetivo
                //=>hemos ganado el juego
                if(aciertos == objetivo){
                    System.out.println("Has Ganado el Juego");
                    salir = true;
                }
            }else{
            System.out.println("Ha perdido");
            salir=true;
        }
    
    }while (!salir);
    }
}
