//Per fer aquesta activitat he continuat seguint el model de les altres, en aquest cas tenom un programa on primerament carregara o creara de nou un arxiu TXT. Consta d'un menu amb 5 opcions (afegir, modificar, eliminar,
//mostar y sortir y guardar.) No fara falta posar el .txt, ja que el programa ho posara sol.

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tasca {
    private String titol;                           //Definim les 4 variables d'instancia de la tasca.
    private String descripcio;
    private LocalDate dataVenciment;
    private String estat;

    public Tasca(String titol, String descripcio, LocalDate dataVenciment, String estat) {            //Constructor de la classe i inicialitzem les varibles d'instancia.
        this.titol = titol;
        this.descripcio = descripcio;
        this.dataVenciment = dataVenciment;
        this.estat = estat;
    }

    public String getTitol() {                          //Metodes d'accés (getters i setters) per les varibles del personatges.
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public LocalDate getDataVenciment() {
        return dataVenciment;
    }

    public void setDataVenciment(LocalDate dataVenciment) {
        this.dataVenciment = dataVenciment;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {                         //Convertim en una cadena de text i les caracteristiques les posem separades per comes.
        return titol + "," + descripcio + "," + dataVenciment + "," + estat;
    }
}

class GestorTasques {
    private List<Tasca> tasques;   //Declarem la llista de les caracteristiques de la tasca.
    private Scanner scanner;

    public GestorTasques() {        //Declarem el constructor de la classe GestorTasques per inicialitzar la llista.
        this.tasques = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void carregarArxiuTasques(String nomFitxer) {             //Declarem el metode carregarArxiuTasques i el nom del arxiu per carregar les taques.
        try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {       //Iniciem el BufferedReader per llegir els caracters del arxiu i decalrem la variable registre per emmagatzemar les linees de text.
            String registre;                               
            while ((registre = br.readLine()) != null) {
                String[] posicio = registre.split(",");             //Asignem cada registre a cada variable utilitzant la coma com a delimitador i les afegim a les variables
                String titol = posicio[0];
                String descripcio = posicio[1];
                LocalDate dataVenciment = LocalDate.parse(posicio[2]);
                String estat = posicio[3];
                tasques.add(new Tasca(titol, descripcio, dataVenciment, estat));            //Afegim els nous registres a la classe Tasca
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void guardarArxiuTasques(String nomFitxer) {     //Declarem el metode guardarArxiuTasques i el nom del arxiu per guardar les taques.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomFitxer))) {       //Iniciem el BufferedWriter per escriure els caracters al arxiu.
            for (Tasca tasca : tasques) {          //Escrivim a partir del toString les lines de text separats per comes i el bw.newLine fa que es salti de linea per cada tasca.
                bw.write(tasca.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afegirTascaArxiu() {               //Declarem el metode afegirTascaArxiu.
        System.out.print("Insereix el Titol: ");
        String titol = scanner.nextLine();
        System.out.print("Insereix la Descripcio: ");
        String descripcio = scanner.nextLine();
        System.out.print("Insereix Data de venciment (Exemple: 2024-05-17): ");
        LocalDate dataVenciment = LocalDate.parse(scanner.nextLine());
        System.out.print("Insereix l'Estat (pendent, en curs, completada): ");
        String estat = scanner.nextLine();
        tasques.add(new Tasca(titol, descripcio, dataVenciment, estat));       //Creem la nova tasca amb les caracteristiques escollides.
        System.out.println("Tasca afegida");
    }

    public void modificarTascaArxiu() {          //Declarem el metode modificarTascaArxiu.
        System.out.print("Insereix el titol de la tasca a modificar: ");
        String titol = scanner.nextLine();
        for (Tasca tasca : tasques) {
            if (tasca.getTitol().equalsIgnoreCase(titol)) {  //Preguntem al usuari el nom de la tasca per poder filtrar-la i llavors modificarla, si la troba pasara a la següent opció i sino sortira un avís de tasca no trobada.
                System.out.println("Tasca Trobada");
                System.out.print("Vols cambiar la descripcio? (Introdueix SI o NO): ");    //Preguntarem al usuari si vols cambiar la descripcio, si introdueix per terminal SI tindrá la opció de intoduir la nova descipcio, si introdueix NO preguntara la següent pregunta.
                String novaDescripcioSi = scanner.nextLine();
                if (novaDescripcioSi.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix la nova descripcio: ");
                    String novaDescripcio = scanner.nextLine();
                    tasca.setDescripcio(novaDescripcio);
                }
                System.out.print("Vols cambiarla data de venciment? (Introdueix SI o NO): ");   //Preguntarem al usuari si vols cambiar la data de venciment, si introdueix per terminal SI tindrá la opció de intoduir la nova data de venciment, si introdueix NO preguntara la següent pregunta.
                String novaDataVencimentSi = scanner.nextLine();
                if (novaDataVencimentSi.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix la nova data (Exemple: 2024-05-17): ");
                    LocalDate novaDataVenciment = LocalDate.parse(scanner.nextLine());
                    tasca.setDataVenciment(novaDataVenciment);
                }
                System.out.print("Vols cambiar l'estat? (Introdueix SI o NO): ");   //Preguntarem al usuari si vols cambiar l'estat, si introdueix per terminal SI tindrá la opció de intoduir el nou estat, si introdueix NO preguntara la següent pregunta.
                String nouEstatSi = scanner.nextLine();
                if (nouEstatSi.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix el nou estat (pendent, en curs, completada): ");
                    String nouEstat = scanner.nextLine();
                    tasca.setEstat(nouEstat);
                }
                System.out.println("Tasca modificada");    //Avís per quan la tasca es modifiqui correctament.
                return;
            }
        }
        System.out.println("Aquesta tasca no esta en el gestor");         //Avís per quan introduïm el nom d'una tasca que no existeix.
    }

    public void eliminarTascaArxiu() {          //Declarem el metode eliminarTascaArxiu.
        System.out.print("Introdueix la tasca a eliminar: ");       //Introduïm el titol de la tasca que volem eliminar
        String titol = scanner.nextLine();
        for (int i = 0; i < tasques.size(); i++) {
            if (tasques.get(i).getTitol().equalsIgnoreCase(titol)) {         //Busquem el nom del titol en la llista i si el troba elimina tots els registres de la tasca.
                tasques.remove(i);
                System.out.println("Tasca eliminada");           //Avís per quan la tasca s'ha eliminat.
                return;
            }
        }
        System.out.println("No s'ha trobat cap tasca amb aquest titol.");         //Avís per quan introduïm el nom d'una tasca que no existeix.
    }

    public void mostrarTasques() {          //Declarem el metode mostrarTasques i Mostrem per consola les tasques disponibles amb les seves 4 caracteristiques
        System.out.println("Tasques disponibles:");
        for (Tasca tasca : tasques) {
            System.out.println("Titol: " + tasca.getTitol() + ", Descripcio: " + tasca.getDescripcio() + ", Data de venciment: " + tasca.getDataVenciment() + ", Estat: " + tasca.getEstat());
        }
    }

    public void sortir() {   //Declarem el metode sortir per poder sortir del programa
        scanner.close();
        System.exit(0);
    }
}

public class GestorDeTasques2 {                                                   //Aquest sera el metode Main del programa.
    private static final String MSG_1 = "********GESTOR DE TASQUES********";     //Declarem els missatges del menu del gestor.
    private static final String MSG_2 = "1. Afegir una nova tasca";
    private static final String MSG_3 = "2. Modificar una tasca";
    private static final String MSG_4 = "3. Eliminar una tasca";
    private static final String MSG_5 = "4. Mostar la llista de tasques";
    private static final String MSG_6 = "5. Sortir i Guardar";
    private static final String MSG_7 = "*******************************";
    private static final String MSG_8 = "Selecciona una opcio: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MSG_1);
        System.out.println("INFO: Si el fitxer no existeix es creara automaticament al introduir el nom, si ja existeix al introduir el nom detectara l'arxiu.");
        System.out.print("Introdueix el nom del fitxer de tasques: ");       //Introduim nom de l'arxiu
        String nomFitxer = scanner.nextLine() + ".txt";          //Afegim l'extensió .txt per l'arxiu.

        GestorTasques gestor = new GestorTasques();
        File fitxer = new File(nomFitxer);                //Si l'arxiu existeix carreguem l'arxiu amb les tasques.
        if (fitxer.exists()) {
            gestor.carregarArxiuTasques(nomFitxer);
            System.out.println("Arxiu carregat");
        }

        while (true) {                      //Printem tots els missatges.
            System.out.println(MSG_1);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.print(MSG_8);
            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {                       //Aquest switch donara l'opció de poder escollir les opcions en el menu que volguem, cridant als 5 metodes possibles.
                case 1:
                    gestor.afegirTascaArxiu();
                    break;
                case 2:
                    gestor.modificarTascaArxiu();
                    break;
                case 3:
                    gestor.eliminarTascaArxiu();
                    break;
                case 4:
                    gestor.mostrarTasques();
                    break;
                case 5:
                    gestor.guardarArxiuTasques(nomFitxer);
                    System.out.println("*****GESTOR FINALITZAT****");
                    gestor.sortir();
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        }
    }
}

