/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Maikol
 */
public class Tablero {
    private String tablero[][];//aqui defino el tablero
    private int minas[][];//una matriz para indicar que posiciones se van a encontrar las minas
    private boolean elegidos[][];//y otra matriz para indicar que posiciones son las que el jugador elige al momento de jugar
    private int filas;
    private  int columnas;
    
    public Tablero(){
        filas=6;
        columnas=6;
        tablero=new String[filas][columnas];//aqui reservo para el tamaño de la matriz espacios que almacenan cadenas
        minas=new int[filas][columnas];//aqui reservo numeros enteros
        elegidos=new boolean[filas][columnas];//aqui reservo espacios que almacenan los estados si tal posicion fue elegida
        for (int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                elegidos[i][j]= false;//inicialmente todas las posiciones no son elegidas asi que a todo false
            }
        }
    }
 //este metodo indica la forma que voy a generar las minas aleatoriamente 
 //para este caso elegi lanzar un dado
    public int lanzarDado(){
        int numero=0;
        do{
            numero=(int ) (Math.random()* 10);
        } while (numero < 1 || numero > 6);
        return numero;
    }
    public void generarMinas(){
       for (int i=0; i<filas; i++){
           for (int j=0; j < columnas; j++){
//sice lanza el dado y sale numero par entonces que en estas posicion abra una mina
               if (lanzarDado() % 2 ==0){
                    minas[i][j]=1;// y para deferenciarlo le asigno 1
                  //Entonces si el valor es 1 el igual o mayor hay mina y si el valor es 0=> no hay mina
               }
           }
       }
    }
   public int cantidadCasillerosSinMinas(){
       int contador=0;
       for (int i=0; i < filas; i++){
            for (int j=0; j < columnas; j++){
           //aqui pregunto si esta posicion de tablero no contiene una mina
                 if (!tablero[i][j].equals("M")){
              //si no contine actualizo el contador
            contador++;
            
         }
       }
           
    }
   return contador;
  }
   public void limpiarMinas(){
       for (int i = 0; i < filas; i++){
           for (int j = 0; j < columnas; j++){
               minas[i][j] = 0;
           }
       }
   }
   public void llenarTablero(){
       generarMinas();
       int numMinasAlrededor = 0;
       for (int i = 0; i < filas; i++){
           for (int j = 0; j < columnas; j++){
               if (minas[i][j] == 1){
                   //en todas las posiciones donde la matriz de minas contengan 1
                   //dire entonces en esas mismas posiciones en mi tablero voy a marcar que hay minas
                   tablero[i][j] = "M";// y le asigno una M:mina
                   
               } else{
                   
                   //caso contrario en las posociones que no existen minas
                   //el valor que contendran estos casilleros sera la cantidad de minas que hay a su alrededor 
                   //Primer caso si estamos en la primer fila o la última fila 
                   if(i == 0 || i == 5){
                       
                       //Si estamos en la primer fila
                       if(i == 0){
                           //Ahora si estamos el la primera columna o en la última columna dentro de la primera fila
                           if(j == 0 || j == 5){
                               //si estamos en primera columna dentro de la primera fila
                               if(j == 0){
                                   //=> empiezo a sumar como estoy en la posicion fila:0 y columna:0
                                   //estamos en el extremo superior izquierdo.
                                   //asi que comensamos contando por minas[i][j] y avansamos a la siguiente comlumna [i][j+1] manteniendo la fila
                                   //luego bajamos una fila [i+1] y contamos la columna primera[j] y despues avansamos con la siguiente columna[i+1][j+1]
                                   //recordar que cada elemento de la matriz mina solo tiene 2 valores o bien 1 o bien 0
                                   //1: si hay mina 0: sino hay mina
                                   tablero[i][j] = "" + (minas[i][j] + minas[i][j + 1] + minas[i + 1][j] + minas[i + 1][j + 1]);
                                   
                               }
                               if(j == 5){
                                   // y bueno asi continuo la logica para los demás casos
                                   tablero[i][j] = "" + (minas[i][j - 1] + minas[i][j] + minas[i + 1][j - 1] + minas[i + 1][j]);
                               }
                           }else{
                               tablero[i][j] = "" + (minas[i][j - 1] + minas[i][j] + minas[i][j + 1] + minas[i + 1][j - 1]+ minas[i + 1][j] + minas[i + 1][j + 1]);
                           }
                       }
                       if(i == 5){
                           if(j == 0 || j == 5){
                               if(j == 0){
                                 tablero[i][j] = "" + (minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j] + minas[i][j + 1]);  
                               }
                               if(j == 5){
                                   tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i][j - 1] + minas[i][j]);
                               }
                           }else{
                               tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j - 1] + minas[i][j] + minas[i][j + 1]);
                           }
                       }
                   }else{
                       if(j == 0 || j == 5){
                           if(j ==0){
                               tablero[i][j] = "" + (minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j] + minas[i][j + 1] + minas[i + 1][j] + minas[i + 1][j + 1]);
                           }
                           if(j == 5){
                               tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i][j - 1] + minas[i][j] + minas[i + 1][j - 1] + minas[i + 1][j]);
                           }
                       }else{
                           tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j - 1] + minas[i][j] + minas[i][j + 1]);
                       }
                   }
               }
           }
       }
   }
   public void mostrarTablero(){
       //llenarTablero();
       for(int i = 0; i < filas; i++){
           for(int j = 0; j < columnas; j++){
               //para mostrar el tablero digo
               //solo las posiciones de la matriz donde no se a elegido voy a mostrar su contenido
               if(elegidos[i][j] == false){
                   if(j == 5){
                     System.out.println(" [" + tablero[i][j] + "]");
                   }else{
                       System.out.println(" [" + tablero[i][j] + "]");
                   }
               }else{
                   //caso contrario a esa posicion ha sido elegido hago de cuenta
                   //de que el casillero ha sido volteado entonces muestro vacio
                   if(j == 5){
                       System.out.println(" [ ] ");
                   }else{
                       System.out.println(" [ ] ");
                   }
               }
           }
       }
       
   }
   //cuando el jugador elige un casillero
   //en si la accion que manda es voltear casillero
   //para saber si en ese casillero hay mina o no hay
   //si hay mina recordar que pierde el juego
   //sino hay mina continua avansando pero el programa le muestra en casillero que eligio la cantidad de minas que hay asu alrededor
   public boolean voltearCasillero(int fila, int columna){
       boolean continuar = false;
       for(int i = 0; i < filas; i++){
           for(int j = 0; j < columnas; j++){
               //sinos encontramos en la posicion que el jugador eligio
              if(i == fila & j == columna){
                  //=>preguntamos si en ese casillero hay mina
                  //=>si hay mina continuar asignamos false
                  //=> y con el lo indicaremos en la clase juego que ya no puede continuar que por lo tanto ha perdido el juego.
                  if(tablero[i][j].equals("M")){
                      continuar = false;
                  }else{
                      elegidos[i][j] = true;
                      continuar=true;
                  }
                  
              } 
           }
       }
    return continuar;
   }
}
