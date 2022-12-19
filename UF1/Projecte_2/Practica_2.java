package cat.institutmvm.Practica1;
import java.util.Scanner;

/**
 *
 * @author danieL
 */
public class Practica_2 {

    private static final String MSG_1 = "Introdueix el id: ";
    private static final String MSG_2 = "Introdueix la edat: ";
    private static final String MSG_3 = "Introdueix el tipus de venta:\nvenda lliure(0)\npensionista(1)\ncarnet jove(2)\nsoci(3) ";
    private static final String MSG_4 = "Introdueix l'import de la compra: ";
    private static final String MSG_5 = "Introdueix el telefon de contacte: ";
    private static final String MSG_6 = "Tens un error, torna a introduïrlo: ";
    private static final String MSG_7 = "Registre inserit";
    private static final String MSG_8 = "Dades registrades ";
    private static final String MSG_9 = "Has seleccionat l'opció Venda lliure (0)";
    private static final String MSG_10 = "Has seleccionat l'opció Pensionista (1)";
    private static final String MSG_11 = "Has seleccionat l'opció Carnet jove (2)";
    private static final String MSG_12 = "Has seleccionat l'opció Soci (3)";
    private static final String MSG_13 = "Id\tEdat\tTipus\t\tImporte\tTelefon";
    private static final String MSG_14 = "Cuants registres vols introduir: ";
    private static final String MSG_15 = "Venda lliure ";
    private static final String MSG_16 = "Pesionista ";
    private static final String MSG_17 = "Carnet jove ";
    private static final String MSG_18 = "Soci ";
    private static final String MSG_19 = "Vols consultar per tipus de client? 1 -> Si  0 -> No ";
    private static final String MSG_20 = "Tens un error";
    private static final String MSG_21 = "Quin tipus de client vols? Venda lliure = 0, Pesionista = 1, Carnet jove = 2, Soci = 3 ";
    private static final String MSG_22 = "Vols veure un resum estadístic de les dades? 1 -> Si  0 -> No";
    private static final String MSG_23 = "La mitjana d'edat és: ";
    private static final String MSG_24 = "Importe total ";
    private static final String MSG_25 = "S'ha acabat el programa";
    private static final int MINIM_ID = 111;
    private static final int MAXIM_ID = 999;
    private static final int MINIM_EDAT = 14;
    private static final int MAXIM_EDAT = 120;
    private static final int MINIM_TIPUS = 0;
    private static final int MAXIM_TIPUS = 3;
    private static final int MINIM_IMPORTE = 0;
    private static final int MAXIM_IMPORTE = 1000;
    private static final long MINIM_TELEFONO = 111111111;
    private static final long MAXIM_TELEFONO = 999999999;
    private static final int SUM_TIPUS = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cliente, count = 0, alternar = 0, consultar = 0, tipusCli = 0, edats = 0, tipus0 = 0, tipus1 = 0, tipus2 = 0, tipus3 = 0, totalimp = 0;
        boolean validador = true;

        System.out.println(MSG_14);
        cliente = sc.nextInt();
        int[] id = new int[cliente];
        int[] edat = new int[cliente];
        int[] tipus = new int[cliente];
        String[] tipusString = new String[cliente];
        int[] importe = new int[cliente];
        int[] telefono = new int[cliente];

        for (int i = 0; i < id.length; i++) {
            do {
                System.out.println(MSG_1);
                id[i] = sc.nextInt();
                if (id[i] < MINIM_ID || id[i] > MAXIM_ID) {
                    System.out.println(MSG_6);
                }
                count++;
            } while (count < 3 && (id[i] < MINIM_ID || id[i] > MAXIM_ID));

            if (count < 3 && (id[i] >= MINIM_ID || id[i] <= MAXIM_ID)) {
                count = 0;
                do {
                    System.out.println(MSG_2);
                    edat[i] = sc.nextInt();
                    if (edat[i] < MINIM_EDAT || edat[i] > MAXIM_EDAT) {
                        System.out.println(MSG_6);
                    }
                    count++;
                } while (count < 3 && (edat[i] < MINIM_EDAT || edat[i] > MAXIM_EDAT));
            }

            if (count < 3 && (edat[i] >= MINIM_EDAT || edat[i] <= MAXIM_EDAT)) { 
                count = 0;
                do {
                    System.out.println(MSG_3);
                    tipus[i] = sc.nextInt();
                    if (tipus[i] < MINIM_TIPUS || tipus[i] > MAXIM_TIPUS) {
                        System.out.println(MSG_6);
                    }
                    count++;
                } while (count < 3 && (tipus[i] < MINIM_TIPUS || tipus[i] > MAXIM_TIPUS));
                switch (tipus[i]) {
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
            }
            if (count < 3 && (tipus[i] >= MINIM_TIPUS || tipus[i] <= MAXIM_TIPUS)) {
                count = 0;
                do {
                    System.out.println(MSG_4);
                    importe[i] = sc.nextInt();
                    if (importe[i] < MINIM_IMPORTE || importe[i] > MAXIM_IMPORTE) {
                        System.out.println(MSG_6);
                    }
                    count++;
                } while (count < 3 && (importe[i] < MINIM_IMPORTE || importe[i] > MAXIM_IMPORTE));
            }

            if (count < 3 && (importe[i] >= MINIM_IMPORTE || importe[i] <= MAXIM_IMPORTE)) {
                count = 0;
                do {
                    System.out.println(MSG_5);
                    telefono[i] = sc.nextInt();
                    if (telefono[i] < MINIM_TELEFONO || telefono[i] > MAXIM_TELEFONO) {
                        System.out.println(MSG_6);
                    }
                    count++;
                } while (count < 3 && (telefono[i] < MINIM_TELEFONO || telefono[i] > MAXIM_TELEFONO));
            }
            System.out.println(MSG_7);
        }
        for (int i = 0; i < edat.length - 1; i++) {
            for (int x = i + 1; x < edat.length; x++) {
                if (edat[i] > edat[x]) {
                    alternar = id[i];
                    id[i] = id[x];
                    id[x] = alternar;
                    alternar = edat[i];
                    edat[i] = edat[x];
                    edat[x] = alternar;
                    alternar = tipus[i];
                    tipus[i] = tipus[x];
                    tipus[x] = alternar;
                    alternar = importe[i];
                    importe[i] = importe[x];
                    importe[x] = alternar;
                    alternar = telefono[i];
                    telefono[i] = telefono[x];
                    telefono[x] = alternar;
                }
            }
        }
        for (int i = 0; i < tipus.length; i++) { 
            switch (tipus[i]) {                  
                case 0:
                    tipusString[i] = (MSG_15);
                    break;
                case 1:
                    tipusString[i] = (MSG_16);
                    break;
                case 2:
                    tipusString[i] = (MSG_17);
                    break;
                case 3:
                    tipusString[i] = (MSG_18);
                    break;
            }
        }
        System.out.println(MSG_13);
        for (int i = 0; i < cliente; i++) {
            System.out.print(id[i] + "\t");
            System.out.print(edat[i] + "\t");
            System.out.print(tipusString[i] + "\t");
            System.out.print(importe[i] + "\t");
            System.out.print(telefono[i] + "\n");
        }
        do {
            System.out.println(MSG_19);
            validador = sc.hasNextInt();
            if (validador) {
                consultar = sc.nextInt();
                if (consultar < 0 || consultar > 1) {
                    System.out.println(MSG_20);
                    validador = false;
                }
            } else {
                sc.next();
                System.out.println(MSG_20);
            }
        } while ((!validador));
        if (consultar == 1) {
            do {
                System.out.println(MSG_21);
                if (validador) {
                    tipusCli = sc.nextInt();
                    if ((tipusCli < 0) || (tipusCli > 1)) {
                        System.out.println(MSG_17);
                    }
                } else {
                    sc.next();
                    System.out.println(MSG_17);
                }
            } while ((!validador));
            if (tipusCli == 0) {
                System.out.println(MSG_13);
                for (int i = 0; i < tipus.length; i++) {
                    if (tipus[i] == 0) {
                        System.out.print(id[i] + "\t");
                        System.out.print(edat[i] + "\t");
                        System.out.print(tipusString[i] + "\t");
                        System.out.print(importe[i] + "\t");
                        System.out.print(telefono[i] + "\n");
                    }
                }
            }
            if (tipusCli == 1) {
                System.out.println(MSG_13);
                for (int i = 0; i < tipus.length; i++) {
                    if (tipus[i] == 1) {
                        System.out.print(id[i] + "\t");
                        System.out.print(edat[i] + "\t");
                        System.out.print(tipusString[i] + "\t");
                        System.out.print(importe[i] + "\t");
                        System.out.print(telefono[i] + "\n");
                    }
                }
            }
            if (tipusCli == 2) {
                System.out.println(MSG_13);
                for (int i = 0; i < tipus.length; i++) {
                    if (tipus[i] == 2) {
                        System.out.print(id[i] + "\t");
                        System.out.print(edat[i] + "\t");
                        System.out.print(tipusString[i] + "\t");
                        System.out.print(importe[i] + "\t");
                        System.out.print(telefono[i] + "\n");
                    }
                }
            }
            if (tipusCli == 3) {
                System.out.println(MSG_13);
                for (int i = 0; i < tipus.length; i++) {
                    if (tipus[i] == 3) {
                        System.out.print(id[i] + "\t");
                        System.out.print(edat[i] + "\t");
                        System.out.print(tipusString[i] + "\t");
                        System.out.print(importe[i] + "\t");
                        System.out.print(telefono[i] + "\n");
                    }
                }
            }

            System.out.println(MSG_22);
            consultar = sc.nextInt();
            if (consultar == 1) {
                for (int i = 0; i < edat.length; i++) {
                    edats = edats + edat[i];
                }
                System.out.println(MSG_23 + edats / cliente);
                for (int i = 0; i < tipus.length; i++) {
                    if (tipus[i] == 0) {
                        tipus0 = tipus0 + SUM_TIPUS;
                    }
                    if (tipus[i] == 1) {
                        tipus1 = tipus1 + SUM_TIPUS;
                    }
                    if (tipus[i] == 2) {
                        tipus2 = tipus2 + SUM_TIPUS;
                    }
                    if (tipus[i] == 3) {
                        tipus3 = tipus3 + SUM_TIPUS;
                    }
                }
                if (tipus0 > 0) { 
                    System.out.println(MSG_15 + tipus0);
                }
                if (tipus1 > 0) { 
                    System.out.println(MSG_16 + tipus1);
                }
                if (tipus2 > 0) { 
                    System.out.println(MSG_17 + tipus2);
                }
                if (tipus3 > 0) { 
                    System.out.println(MSG_18 + tipus3);
                }
            }
            for(int i = 0; i < importe.length; i++){ 
                totalimp = totalimp + importe[i];
            }
                System.out.println(MSG_24 + totalimp);
        }
        System.out.println(MSG_25);
    }
}
