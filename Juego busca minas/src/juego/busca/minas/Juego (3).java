                                                                                                    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.Scanner;
import javax.swing.JOptionPane;

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
          //Se utiliza un JOptionPane.showInputDialog para preguntarle si quiere jugar de nuevo o salir del juego. 
          String opcion = JOptionPane.showInputDialog(null, "¿Que desea hacer? 1.Jugar 2.Salir");
          
            switch (opcion) {
                case "1":
                    jugar();
                    break;
                case "2":
                    System.exit(0);
            }
        }
    }//mi menu de opciones

    
    public void jugar(){
        //System.out.pritln("Nombre del Jugador: ");
        T.llenarTablero();
        T.mostrarTablero();
        int fila, columna;
        int aciertos = 0;
        int objetivo = T.cantidadCasillerosSinMinas();
        boolean salir = false;
        System.out.println("cantidad de casilleros sin minas:" + T.cantidadCasillerosSinMinas());
        do{
            System.out.println("Elige un casillero : ");
            System.out.println("Ingresando sus coordenadas");
            System.out.println("FILA: ");
            fila = leerDato.nextInt();
            System.out.println("Columna:");
            columna = leerDato.nextInt();
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
                  JOptionPane.showMessageDialog(null,"Has Ganado la Partida","INFORMACION",JOptionPane.INFORMATION_MESSAGE);
                    salir = true;
                }
            }else{
              JOptionPane.showMessageDialog(null, "Has Perdido el juego", "ERROR", JOptionPane.ERROR_MESSAGE);
            salir=true;
        }
    
    }while (!salir);
    }
}
