/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.institutmvm.AP2;
import java.util.Scanner;
/**
 *
 * @author alumne_2n
 */
public class AP2_Act8_ {
    public static final String MSG_1 = "Introduce un numero:";
    public static final String MSG_2 = "Introduce un apartado:";
    public static final String MSG_3 = "Cuantos numeros quieres introducir:";
        public static final String MSG_4 = "Introduce un numero";

    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num, usu, sum = 0, apar, cantidad, cont = 0; 
    System.out.println(MSG_2);
    apar = sc.nextInt();
    
    switch (apar){
        case 1:
            do{
                System.out.println(MSG_1);
                num = sc.nextInt();
            }while (num != 0);
            System.out.println("Gracies per utilitzar el programa");
        case 2:
            System.out.println(MSG_3);
            cantidad = sc.nextInt();
            
            do{
                System.out.println(MSG_4);
                usu = sc.nextInt();
                cont++;
            }while(cont != cantidad);
            System.out.println("Gracies per utilitzar el programa");
    }
    
}
}