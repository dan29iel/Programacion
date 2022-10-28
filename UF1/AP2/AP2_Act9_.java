/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.institutmvm.AP2;
import static cat.institutmvm.AP2.AP2_Act8_.MSG_2;
import java.util.Scanner;

/**
 *
 * @author alumne_2n
 */
public class AP2_Act9_ {
    public static final String MSG_1 = "Introduce un numeros:";
    public static final String MSG_2 = "La media de las notas sera ";
    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    float num = 1, suma = 0;
    int cont = 0;
    System.out.println(MSG_1);
    num = sc.nextInt();
    
    while(num > 0){
        System.out.println(MSG_1);
        num = sc.nextInt();
        if (num > 0){
            suma=suma+num;
            cont++;      
        }    
    }
    
    if (cont > 0){
        System.out.println(MSG_2 + suma/cont);
    }
 
}
}

