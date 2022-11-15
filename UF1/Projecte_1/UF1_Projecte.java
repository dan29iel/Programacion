package cat.institutmvm.Projecte_1;
import java.util.Scanner;

/**
 *
 * @author alumne_2n
 */
public class UF1_Projecte {

    private static final String MSG_1 = "Introdueix el id: ";
    private static final String MSG_2 = "Introdueix la edat: ";
    private static final String MSG_3 = "Introdueix el tipus de venta:\nvenda lliure(0)\npensionista(1)\ncarnet jove(2)\nsoci(3) ";
    private static final String MSG_4 = "Introdueix l'import de la compra: ";
    private static final String MSG_5 = "Introdueix el telefon de contacte: ";
    private static final String MSG_6 = "Tens un error, torna a introduïrlo: ";
    private static final String MSG_7 = "S'acaba el programa.";
    private static final String MSG_8 = "Dades registrades: ";
    private static final String MSG_9 = "Has seleccionado la opcion Venda lliure (0)";
    private static final String MSG_10 = "Has seleccionado la opcion Pensionista (1)";
    private static final String MSG_11 = "Has seleccionado la opcion Carnet jove (2)";
    private static final String MSG_12 = "Has seleccionado la opcion Soci (3)";
    private static final String MSG_13 = "Id\tEdat\tTipus\t\tImporte\tTelefon";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id, edat, tipus, importe, i = 0;
        long telefon;

        do {
            System.out.println(MSG_1);
            id = sc.nextInt();
            if (id >= 111 && id <= 999) {
                do {
                    System.out.println(MSG_2);
                    edat = sc.nextInt();
                    if (edat >= 14 && edat <= 120) {
                        do {
                            System.out.println(MSG_3);
                            tipus = sc.nextInt();
                            if (tipus >= 0 && tipus <= 3) {
                                switch (tipus) {
                                    case 0:
                                        System.out.println(MSG_9);
                                        break;
                                    case 1:
                                        System.out.println(MSG_10);
                                        break;
                                    case 2:
                                        System.out.println(MSG_11);
                                        break;
                                    case 3:
                                        System.out.println(MSG_12); 
                                        break;
                                }
                                do {
                                    System.out.println(MSG_4);
                                    importe = sc.nextInt();
                                    if (importe >= 0 && importe <= 1000) {
                                        do {
                                            System.out.println(MSG_5);
                                            telefon = sc.nextLong();
                                            if(telefon >= 111111111 && telefon <= 999999999){
                                                System.out.println(MSG_8);
                                                i = 3;
                                                if(tipus == 0){
                                                    System.out.println(MSG_13);
                                                    System.out.println(id +"\t"+edat+"\t"+"Venda lliure"+"\t"+importe+"\t"+telefon);
                                                }
                                                if(tipus == 1){
                                                    System.out.println(MSG_13);
                                                    System.out.println(id +"\t"+edat+"\t"+"Pensionista"+"\t"+importe+"\t"+telefon);
                                                }
                                                if(tipus == 2){
                                                    System.out.println(MSG_13);
                                                    System.out.println(id +"\t"+edat+"\t"+"Carnet Jove"+"\t"+importe+"\t"+telefon);
                                                }
                                                if(tipus == 3){
                                                    System.out.println(MSG_13);
                                                    System.out.println(id +"\t"+edat+"\t"+"Soci"+"\t"+importe+"\t"+telefon);
                                                }
                                            }else{
                                                System.out.println(MSG_6);  
                                            }
                                                i = i + 1;
                                        } while (i < 3);
                                    } else {
                                        System.out.println(MSG_6);
                                    }
                                    i = i + 1;
                                } while (i < 3);
                            } else {
                                System.out.println(MSG_6);
                            }
                            i = i + 1;
                        } while (i < 3);
                    } else {
                        System.out.println(MSG_6);
                    }
                    i = i + 1;
                } while (i < 3);
            } else {
                System.out.println(MSG_6);
            }
            i = i + 1;
        } while (i < 3);
        System.out.println(MSG_7);
    }
}
