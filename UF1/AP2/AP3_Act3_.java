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
public class AP3_Act3_ {
    private static final String MSG_1 = "Introdueix un numero: ";
    private static final String MSG_2 = "Introdueix un numero: ";
    private static final String MSG_3 = "Introdueix un numero: ";
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(MSG_1);
        int num1, num2, num3;
        num1 = sc.nextInt();
        System.out.println(MSG_2);
        num2 = sc.nextInt();
        System.out.println(MSG_3);
        num3 = sc.nextInt();
        
        if(num1<0){
            System.out.println("Es negatiu");
        }
        
        if(num1>35){
            System.out.println(num1 + " es major que 35");
        }
        
        if(num1 > 0 && num1 < 100){
            System.out.println(num1 + "es positiu i menor que 100");
        }
        
        if(num1 >= -3 && num1 <= 27){
            System.out.println(num1 + " pertany a l'interval [-1,27]");
        }
        
        if(num1 >= 25 && num1 <= 50){
            System.out.println(num1 + " pertany a l'interval [25,50]");
        }
        
        if(num1%2 !=0){
            System.out.println(num1 + " el numero es senar");
        }
        
        if(num1%2 == 0){
            System.out.println("El quadrat sera " + num1*num1);
        }else{
            System.out.println("El cub sera " + num1*num1*num1);
        }
        
        if(num1>num2){
            System.out.println(num1 + " Es mes gran que " + num2);
        }else{
            System.out.println(num2 + " Es mes gran que " + num1);
        }
        
        if(num1 > num2 && num1 > num3){
            System.out.println(num1 + " Es mes gran que " + num2  + num3);
        }else{
            if(num1 < num2 && num1 > num3){
              System.out.println(num2 + " Es mes gran que " + num1 + num3);  
             }else{
              System.out.println(num3 + " Es mes gran que " + num1 + num2);    
            }
        if(num1%num2 == 0){
            System.out.println(num1 + " Es mes multiple de " + num2);
        }
    }
}
}
