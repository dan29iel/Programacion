/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.institutmvm.AP2;
import java.util.Scanner;


public class AP2_Act4A_ {
    public static final String MSG_1 = "Introdueix un numero del 1 al 12:";
    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println(MSG_1);
    int numMonth;
    numMonth  = sc.nextInt();
    if (numMonth >=1 && numMonth<=12){
        switch (numMonth) {
        case 1:
            System.out.println("Gener");
            break;
        case 2:
            System.out.println("Febrer");
            break;
        case 3:
            System.out.println("Març");
            break;
        case 4:
            System.out.println("Abril");
            break;
        case 5:
            System.out.println("Maig");
            break;
        case 6:
            System.out.println("Juny");
            break;
        case 7:
            System.out.println("Juliol");
            break;
        case 8:
            System.out.println("Agost");
            break;
        case 9:
            System.out.println("Setembre");
            break;
        case 10:
            System.out.println("Octubre");
            break;
        case 11:
            System.out.println("Novembre");
            break;
        case 12:
            System.out.println("Decembre");
            break;
    }
    }else{
        System.out.println("Error"); 
    }
}
}

   