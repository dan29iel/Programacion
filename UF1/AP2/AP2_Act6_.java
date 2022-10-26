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
public class AP2_Act6_ {
    public static final String MSG_1 = "Introduce un año:";
    public static final String MSG_2 = "Introduce un mes:";
    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int año, mes;
    System.out.println(MSG_1);
    año = sc.nextInt();
    System.out.println(MSG_2);
    mes = sc.nextInt();
    
    if(mes >= 1 && mes <=12 && año%4 == 0 && (año%100 == 0 || año%400 == 0)){
        switch (mes){
            case 1:
                System.out.println("Enero tiene 31");
            break;
            case 2:
                System.out.println("Febrero tiene 28");
            break;
            case 3:
                System.out.println("Marzo tiene 31");
            break;
            case 4:
                System.out.println("Abril tiene 30");
            break;
            case 5:
                System.out.println("Mayo tiene 31");
            break;
            case 6:
                System.out.println("Junio tiene 30");
            break;
            case 7:
                System.out.println("Julio tiene 31");
            break;
            case 8:
                System.out.println("Agosto tiene 31");
            break;
            case 9:
                System.out.println("Setiembre tiene 30");
            break;
            case 10:
                System.out.println("Octubre tiene 31");
            break;
            case 11:
                System.out.println("Noviembre tiene 30");
            break;
            case 12:
                System.out.println("Diciembre tiene 31");
            break;    
        }
    }else{
        switch (mes){
            case 1:
                System.out.println("Enero tiene 31");
            break;
            case 2:
                System.out.println("Febrero tiene 29");
            break;
            case 3:
                System.out.println("Marzo tiene 31");
            break;
            case 4:
                System.out.println("Abril tiene 30");
            break;
            case 5:
                System.out.println("Mayo tiene 31");
            break;
            case 6:
                System.out.println("Junio tiene 30");
            break;
            case 7:
                System.out.println("Julio tiene 31");
            break;
            case 8:
                System.out.println("Agosto tiene 31");
            break;
            case 9:
                System.out.println("Setiembre tiene 30");
            break;
            case 10:
                System.out.println("Octubre tiene 31");
            break;
            case 11:
                System.out.println("Noviembre tiene 30");
            break;
            case 12:
                System.out.println("Diciembre tiene 31");
            break;    
        }
    }
    }
}