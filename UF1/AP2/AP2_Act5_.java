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
public class AP2_Act5_ {
    public static final String MSG_1 = "Introduce un año:";

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println(MSG_1);
    int año;
    año = sc.nextInt();
    
    if (año%4 == 0){
        if(año%100 == 0){
            if(año%400 == 0){
                System.out.println("El año "+ año + " es bisiesto.");
            }else{
                System.out.println("El año "+ año + " no es bisiesto.");
            }
        }else{
            System.out.println("El año "+ año + " no es bisiesto.");
        }       
    }else{
            System.out.println("El año "+ año + " no es bisiesto.");
        }
}
}


