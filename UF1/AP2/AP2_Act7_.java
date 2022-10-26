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
public class AP2_Act7_ {
    public static final String MSG_1 = "Introduce un numero del 1 al 4:";
    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int i= 0, num, a=100;
    System.out.println(MSG_1);
    num = sc.nextInt();
    
    while (num == 1 && i <=10){
            System.out.println(i);
            i++;
        }
    
    while (num == 2 && i <=100){
        System.out.println(i);
        i++;
    }
    
    while (num == 3 && i <=100){
        i++;
        if(i%2 == 0){           
            System.out.println(i);
        }    
    }
    
    while (num == 4 && a>0){
        if(i%2 == 0){           
            System.out.println(a);
            a = a-1;
        }    
    }
    }
    
}
