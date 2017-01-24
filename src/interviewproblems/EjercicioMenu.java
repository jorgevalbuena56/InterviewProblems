/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/*"Util" es un paquete muy usado,
   Scanner es una función 
*/
import java.util.Scanner;
import java.util.Arrays;

public class EjercicioMenu {
   
     public static void main(String args[]){
         
         boolean salir = false;
         
         while(!salir){
             
            /*Se crea un constructor de tipo Scanner
                El cual recibe un parametro "System.in"
                Obj -- Hace referencia objeto
            */                          
            Scanner obj = new Scanner (System.in);
            
             System.out.println("\nSeleccione su Operacion:");
             System.out.println("\t 1.- Suma de 2 Numeros:");
             System.out.println("\t 2.- Calculo de Factorial:");
             System.out.println("\t 3.- Media Aritmetica:");
             System.out.println("\t 4.- Salir:");
             
            int opcion = obj.nextInt();
            
            switch(opcion){
                
                case 1: 
                     int numero1;
                     int numero2;
                     int resultado;

                  /*Metodo "System.out.println" que nos sirbe para imprimir una cadena de texto*/  

                    System.out.println ("\nOperación Suma");

                    System.out.println ("\nIngresar el primer numero");

                    /*Scaneo valores 
                      Llamo mi contructor obj.next y el tipo de dato "Int"
                    */  

                    numero1 = obj.nextInt();

                    System.out.println ("\nIngresar el segundo numero");

                    numero2 = obj.nextInt();

                    resultado= numero1 + numero2;

                    System.out.println ("\nEl resultado final: " + resultado);
                    break;
                    
                case 2:
                /* Sacar el Factorial */

                     System.out.println ("\nOperación factorial");

                     System.out.println ("\nIngresar el numero");

                     numero1 = obj.nextInt();

                     int factorial = 1;

                     while (numero1 !=0)

                     { 
                         factorial*=numero1;

                         numero1 --;

                     }

                     System.out.println ("\nEl factor es: " + factorial);                    
                    break;
                    
                case 3:
                    /* Media arimetica con vectores */

                    int array[] = {12,34,56,4,3,2,1,8,9,10};

                    double media = 0.0;

                    for(int i=0; i < array.length; i++){
                        media = media + array[i];
                    }

                    media = media / array.length;

                    System.out.println ("\nLa media de " + Arrays.toString(array) + " es: " + media);

                    break;
                    
                case 4:
                    salir = true;
                    break;
                    
                default:
                    System.out.println("\n La opcion seleccionada no es correcta!");
                    break;
            }
         }
     }
}
