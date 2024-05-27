//Per fer aquesta activitat he seguit el model de les activitats Gestor de Tasques y Sistema de Registre d'estudiants y he implementat el codi per la carrega del arxiu xml per tal de que es registrin el dos primers personatges.
//Aquest programa mostrara un menú de 4 opcions, al executarlo primerament carregara els dos primers personatges del joc, després tindras les opcions disponibles per tal d'afegir personatges nou, poder modificar alguna caracter-
//ristica d'algun d'ells y poder llistar tots el personatges disponibles en el joc amb les seves caracteristiques i finalment tindràs la opció de sortir de joc.

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class Personatge {               //Definim les 5 variables d'instancia del personatge.
    private String nom;
    private int nivell;
    private int vida;
    private int mana;
    private String arma;
    private String armadura;

    public Personatge(String nom, int nivell, int vida, int mana, String arma, String armadura) {           //Constructor de la classe i inicialitzem les varibles d'instancia.
        this.nom = nom;
        this.nivell = nivell;
        this.vida = vida;
        this.mana = mana;
        this.arma = arma;
        this.armadura = armadura;
    }

    public String getNom() {                  //Metodes d'accés (getters i setters) per les varibles del personatges.
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    public String getArma() {
        return arma;
    }
    
    public void setArma(String arma) {
        this.arma = arma;
    }
    
    public String getArmadura() {
        return armadura;
    }
    
    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }
}

class GestioPersonatges {                     //Declarem la llista de les caracteristiques del personatge.
    private List<Personatge> personatges;
    private Scanner scanner;

    public GestioPersonatges() {                     //Declarem el constructor de la classe GestioPersonatges per inicialitzar la llista i truca al metode carregarPersonatges amb la ruta del arxiu xml.
        this.personatges = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        carregarPersonatges("C:\\Users\\danie\\personatges.xml");
    }

    public void carregarPersonatges(String archivoXML) {          //Metode per carregar el personatges desde l'arxiu XML.
        try {
            File arxiuXML = new File("C:\\Users\\danie\\personatges.xml");             //Crearem l'objecte File utilitzant la ruta.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     //Instanciem l'objecte DocumentBuilderFactory i despres creem el DocumentBuilder.
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(arxiuXML);
            NodeList llistaPersonatges = doc.getElementsByTagName("personatge");       //Obtenim la llista de personatges, es a dir, els nodes del document XML.

            for (int i = 0; i < llistaPersonatges.getLength(); i++) {                  //Fem la iteració de la llista de personatges
                Node n = llistaPersonatges.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {                            //Verifiquem si el node és ELEMENT_NODE
                    Element registre = (Element) n;
                    String nom = registre.getElementsByTagName("nom").item(0).getTextContent();       //Extreurem els valors de les 5 acaracteristiques dels personatges amb els mateix noms que hi ha en el document XML.
                    int nivell = Integer.parseInt(registre.getElementsByTagName("nivell").item(0).getTextContent());
                    int vida = Integer.parseInt(registre.getElementsByTagName("puntsDeVida").item(0).getTextContent());
                    int mana = Integer.parseInt(registre.getElementsByTagName("puntsDeMana").item(0).getTextContent());
                    String arma = registre.getElementsByTagName("arma").item(0).getTextContent();
                    String armadura = registre.getElementsByTagName("armadura").item(0).getTextContent();
                    personatges.add(new Personatge(nom, nivell, vida, mana, arma, armadura));         //Afegim els valors a la llista personatges. 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirPersonatge() {                 //Creem el metode per poder inserir el personatges manualment amb les seves 5 caracteristiques.
        System.out.print("Nom del personatge: ");
        String nom = scanner.nextLine();
        System.out.print("Nivell del personatge: ");
        int nivell = scanner.nextInt();
        System.out.print("Vida del personatge: ");
        int vida = scanner.nextInt();
        System.out.print("Mana del personatge: ");
        int mana = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Arma del personatge: ");
        String arma = scanner.nextLine();
        System.out.print("Armadura del personatge: ");
        String armadura = scanner.nextLine();
        personatges.add(new Personatge(nom, nivell, vida, mana, arma, armadura));     //Creem el nou personatges amb les caracteristiques escollides.
        System.out.println("Personatge registrat");
    }

    public void mostrarPersonatges() {                  //Mostrem per consola els personatges disponibles amb les seves 5 caracteristiques.
        System.out.println("Personatges disponibles:");
        for (Personatge personatge : personatges) {
            System.out.println("Nom: " + personatge.getNom() + ", Nivell: " + personatge.getNivell() + ", Vida: " + personatge.getVida() + ", Mana: " + personatge.getMana() + ", Arma: " + personatge.getArma() + ", Armadura: " + personatge.getArmadura());
        }
    }

    public void modificarPersonatge() {                       //Metode per poder modificar les caracteristiques dels personatges.
    System.out.print("Nom del personatge per modificar-lo: ");
    String nom = scanner.nextLine();
    for (Personatge personatge : personatges) { 
        if (personatge.getNom().equalsIgnoreCase(nom)) {         //Preguntem al usuari el nom del personatge per poder filtrar-lo i llavors modificarlo, si el trobar pasara a la següent opció i sino sortira un avís de personatge no trobat.
            System.out.println("Personatge trobat");
            System.out.print("Vols nou nivell? (Introdueix SI o NO): ");      //Preguntarem al usuari si vols cambiar el nivell, si introdueix per terminal SI tindrá la opció de intoduir el nou nivell, si introdueix NO preguntara la següent pregunta.
            String NouNivellsi = scanner.nextLine();
            if (NouNivellsi.equalsIgnoreCase("SI")) {
                System.out.print("Introdueix el nou nivell: ");
                int nouNivell = scanner.nextInt();
                scanner.nextLine();
                personatge.setNivell(nouNivell);
            }

            System.out.print("Vols nous punts de vida? (Introdueix SI o NO): ");   //Preguntarem al usuari si vols cambiar la vida, si introdueix per terminal SI tindrá la opció de intoduir la nova vida, si introdueix NO preguntara la següent pregunta.
            String novaVidaSi = scanner.nextLine();
            if (novaVidaSi.equalsIgnoreCase("SI")) {
                System.out.print("Introdueix els nous punts de vida: ");
                int novaVida = scanner.nextInt();
                scanner.nextLine();
                personatge.setVida(novaVida);
            }

            System.out.print("Vols nous punts de mana? (Introdueix SI o NO): ");    //Preguntarem al usuari si vols cambiar el mana, si introdueix per terminal SI tindrá la opció de intoduir el nou mana, si introdueix NO preguntara la següent pregunta.
            String nouManaSi = scanner.nextLine();
            if (nouManaSi.equalsIgnoreCase("SI")) {
                System.out.print("Introdueix els nous punts de mana: ");
                int nouMana = scanner.nextInt();
                scanner.nextLine();
                personatge.setMana(nouMana);
            }

            System.out.print("Vols nova arma? (Introdueix SI o NO): ");         //Preguntarem al usuari si vols cambiar l'arma, si introdueix per terminal SI tindrá la opció de intoduir una nova arma, si introdueix NO preguntara la següent pregunta.
            String novaArmaSI = scanner.nextLine();
            if (novaArmaSI.equalsIgnoreCase("SI")) {
                System.out.print("Introdueix la nova arma: ");
                String arma = scanner.nextLine();
                personatge.setArma(arma);
            }

            System.out.print("Vols nova armadura? (Introdueix SI o NO): ");      //Preguntarem al usuari si vols cambiar l'armadura, si introdueix per terminal SI tindrá la opció de intoduir una nova armadura, si introdueix NO preguntara la següent pregunta.
            String novaArmaduraSi = scanner.nextLine();
            if (novaArmaduraSi.equalsIgnoreCase("SI")) {
                System.out.print("Introdueix la nova armadura: ");
                String armadura = scanner.nextLine();
                personatge.setArmadura(armadura);
            }

            System.out.println("Personatge modificat.");      //Avís per quan el personatge es modifiqui correctament.
            return;
        }
    }
    System.out.println("Aquest personatge no esta en el joc.");      //Avís per quan introduïm el nom d'un personatge que no existeix.
}

public void sortir() {       //Tanquem l'escaner o sortim del programa.
        scanner.close();
        System.exit(0);
    }
}

public class JocAventura {                                                 //Aquest sera el metode Main del programa.
    private static final String MSG_1 = "********JOC DE ROL********";
    private static final String MSG_2 = "1. Insereix personatge nou";      //Declarem els missatges del menu del joc de rol.
    private static final String MSG_3 = "2. Mostrar personatges";
    private static final String MSG_4 = "3. Modificar personatge";
    private static final String MSG_5 = "4. Sortir del joc";
    private static final String MSG_6 = "********TERRA D'OR*********";
    private static final String MSG_7 = "Selecciona una opcio: ";
    public static void main(String[] args) {
        GestioPersonatges menu = new GestioPersonatges();          //Crearem la instacia menu per poder carregar els personatges del arxiu XML. 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(MSG_1);                //Printem tots els missatges.
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.print(MSG_7);
            int opcions = scanner.nextInt();
            scanner.nextLine();

            switch (opcions) {                        //Aquest switch donara l'opció de poder escollir les opcions en el menu que volguem, cridant als 4 metodes possibles.
                case 1:
                    menu.inserirPersonatge();
                    break;
                case 2:
                    menu.mostrarPersonatges();
                    break;
                case 3:
                    menu.modificarPersonatge();
                    break;
                case 4:
                    System.out.println("*******JOC FINALITZAT******");
                    menu.sortir();
                    break;
                default:
                    System.out.println("Opcio de valida");
            }
        }
    }
}
