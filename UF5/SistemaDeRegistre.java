import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Alumne {                          //Declararem les variables d'instància de l'alumne.
    private static int cont = 0;
    private int id;
    private String nom;
    private String cognom;
    private int edat;
    private ArrayList<String> materia;

    public Alumne(String nom, String cognom, int edat) {          //Constructor de la classe i inicialitzem les varibles d'instacia i l'array per a la llista de materies.
        this.id = ++cont;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.materia = new ArrayList<>();
    }

    public int getId() {        //Metodes d'accés a les varibles dl'alumne.
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getCognom() {
        return this.cognom;
    }

    public int getEdat() {
        return this.edat;
    }

    public ArrayList<String> getMateria() {
        return this.materia;
    }

    public void NovaMateria(String materia) {      //Metodes per gestionar les materies afegir/eliminar materia.
        this.materia.add(materia);
    }

    public void EliminarMateria(String materia) {
        this.materia.remove(materia);
    }

    public String toString() {         //Retorna en cadena tota la informació del alumne.
        return "ID: " + id + " Nom: " + nom + " Cognom: " + cognom + " Edat: " + edat + " Materies: " + materia;
    }
}

class RegistreAlumnes {         //Declararem les variables d'instància de la classe RegistreAlumnes
    private HashMap<Integer, Alumne> alumnes;
    private Scanner scanner;

    public RegistreAlumnes() {           //Constructor que inicialitza el HashMap  i l'escaner.
        alumnes = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void NouAlumne(String nom, String cognom, int edat) {              //Metode que serveix per afegir un nou alumne al registre.
        Alumne alumne = new Alumne(nom, cognom, edat);
        alumnes.put(alumne.getId(), alumne);
    }

    public void AfegirMateriaAlumne(int idAlumne, String materia) {           //Metodes per agregar o eliminar una materia a un alumne en especific a partir de la seva ID.
        Alumne alumne = alumnes.get(idAlumne);
        if (alumne != null) {
            alumne.NovaMateria(materia);
        }
    }

    public void EliminarMateriaAlumne(int idAlumne, String materia) {
        Alumne alumne = alumnes.get(idAlumne);
        if (alumne != null) {
            alumne.EliminarMateria(materia);
        }
    }

    public void MostrarAlumnes() {                        //Metodes per mostrar la informació de cada alumne i les materies
        System.out.println("Alumnes registrats:");
        for (Alumne alumne : alumnes.values()) {
            System.out.println(alumne);
        }
    }

    public void mostrarMateriaAlumne(int idAlumne) {
        Alumne alumne = alumnes.get(idAlumne);
        if (alumne != null) {
            System.out.println("Materies de l'alumne " + alumne.getNom() + " " + alumne.getCognom() + ":");
            System.out.println(alumne.getMateria());
        }
    }

    public void sortir() {              //Per sortir del programa.
        scanner.close();
        System.exit(0);
    }
}

public class SistemaDeRegistre {                         //Definim les constants per els missatges, creem una instancia de la classe RegistreAlumnes i l'objecte escaner i fem el while perque surti sempre el menu d'opcions.
    private static final String MSG_1 = "\nOpcions:";
    private static final String MSG_2 = "1. Registrar un nou alumne";
    private static final String MSG_3 = "2. Afegir una nova materia a un alumne registrat";
    private static final String MSG_4 = "3. Eliminar matèria d'un alumne registrat";
    private static final String MSG_5 = "4. Mostrar tots els alumnes registrats"; 
    private static final String MSG_6 = "5. Mostrar les materies d'un alumne";
    private static final String MSG_7 = "6. Surt del programa";
    private static final String MSG_8 = "Selecciona una opcio: ";
    
    public static void main(String[] args) {
        RegistreAlumnes registre = new RegistreAlumnes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(MSG_1);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.println(MSG_7);
            System.out.print(MSG_8);

            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {                         //Amb l'escaner llegirem l'opció que volem per poder executar el 6 casos diferents.
                case 1:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Cognom: ");
                    String cognom = scanner.nextLine();
                    System.out.print("Edat: ");
                    int edat = scanner.nextInt();
                    registre.NouAlumne(nom, cognom, edat);
                    break;
                case 2:
                    System.out.print("ID: ");
                    int idAlumne = scanner.nextInt();
                    scanner.nextLine(); // Netegem el buffer
                    System.out.print("Nova materia: ");
                    String materiaNova = scanner.nextLine();
                    registre.AfegirMateriaAlumne(idAlumne, materiaNova);
                    break;
                case 3:
                    System.out.print("ID: ");
                    idAlumne = scanner.nextInt();
                    scanner.nextLine(); // Netegem el buffer
                    System.out.print("Materia per eliminar: ");
                    String materiaEliminada = scanner.nextLine();
                    registre.EliminarMateriaAlumne(idAlumne, materiaEliminada);
                    break;
                case 4:
                    registre.MostrarAlumnes();
                    break;
                case 5:
                    System.out.print("ID: ");
                    idAlumne = scanner.nextInt();
                    registre.mostrarMateriaAlumne(idAlumne);
                    break;
                case 6:
                    registre.sortir();
                    break;
            }
        }
    }
}
