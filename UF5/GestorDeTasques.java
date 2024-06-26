package task.management;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Tasca {
    private static int cont = 0;
    private int id;
    private String descripcio;
    private boolean tasca_completada;
    private String prioritat;

    public Tasca(String descripcio, String prioritat) {
        this.id = ++cont;
        this.descripcio = descripcio;
        this.tasca_completada = false;
        this.prioritat = prioritat;
    }

    public void marcarTascaCompletada() {
        this.tasca_completada = true;
    }

    public int getID() {
        return this.id;
    }

    public String getDescripcio() {
        return this.descripcio;
    }

    public boolean estaCompletada() {
        return this.tasca_completada;
    }

    public String getPrioritat() {
        return this.prioritat;
    }

    public String toString() {
        String estat_tasca = tasca_completada ? "Completada" : "Pendent";
        return "ID: " + id + ", Descripcio: " + descripcio + ", Prioritat: " + prioritat + ", Estat: " + estat_tasca;
    }
}

class GestorTasques {
    private static final String MSG_1 = "baixa";
    private static final String MSG_2 = "mitjana";
    private static final String MSG_3 = "alta";
    private HashMap<String, ArrayList<Tasca>> llistaPrioritat;
    private HashMap<Integer, Tasca> tasques;
    private Scanner scanner;

    public GestorTasques() {
        llistaPrioritat = new HashMap<>();
        llistaPrioritat.put(MSG_1, new ArrayList<>());
        llistaPrioritat.put(MSG_2, new ArrayList<>());
        llistaPrioritat.put(MSG_3, new ArrayList<>());
        tasques = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void afegirTasca(String descripcio, String prioritat) {
        Tasca tasca = new Tasca(descripcio, prioritat);
        llistaPrioritat.get(prioritat).add(tasca);
        tasques.put(tasca.getID(), tasca);
    }

    public void marcarTascaCompletada(int idTasca) {
        Tasca tasca = tasques.get(idTasca);
        if (tasca != null) {
          tasca.marcarTascaCompletada();
        }
    }

    public void esborrarTasca(int idTasca) {
        Tasca tasca = tasques.remove(idTasca);
        if (tasca != null) {
            String prioritat = tasca.getPrioritat();
            llistaPrioritat.get(prioritat).remove(tasca);
        }
    }

    public void mostrarTotesLesTasques() {
        System.out.println("Totes les tasques:");
        for (Tasca tasca : tasques.values()) {
            System.out.println(tasca);
        }
    }

    public void mostrarTasquesPerPrioritat(String prioritat) {
        System.out.println("Tasques de prioritat " + prioritat + ":");
        for (Tasca tasca : llistaPrioritat.get(prioritat)) {
            System.out.println(tasca);
        }
    }

    public void sortir() {
        scanner.close();
        System.exit(0);
    }
}
        
public class GestorDeTasques {
    private static final String MSG_1 = "\nOpcions:";
    private static final String MSG_2 = "1. Afegeix nova tasca";
    private static final String MSG_3 = "2. Marca una tasca com a completada";
    private static final String MSG_4 = "3. Esborra una tasca";
    private static final String MSG_5 = "4. Mostra totes les tasques"; 
    private static final String MSG_6 = "5. Mostra les tasques per prioritat";
    private static final String MSG_7 = "6. Surt del programa";
    private static final String MSG_8 = "Selecciona una opcio: ";

    
    public static void main(String[] args) {
        GestorTasques gestor = new GestorTasques();
        Scanner scanner = new Scanner(System.in);

        while (true)  {
            System.out.println(MSG_1);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.println(MSG_7);
            System.out.println(MSG_8);

            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    System.out.print("Descripcio de la tasca: ");
                    String descripcio = scanner.nextLine();
                    System.out.print("Prioritat: baixa/mitjana/alta: ");
                    String prioritat = scanner.nextLine().toLowerCase();
                    gestor.afegirTasca(descripcio, prioritat);
                    break;
                case 2:
                    System.out.print("Numero de la tasca per marcar com completada: ");
                    int idTasca = scanner.nextInt();
                    gestor.marcarTascaCompletada(idTasca);
                    break;
                case 3:
                    System.out.print("Numero de la tasca per esborrar: ");
                    idTasca = scanner.nextInt();
                    gestor.esborrarTasca(idTasca);
                    break;
                case 4:
                    gestor.mostrarTotesLesTasques();
                    break;
                case 5:
                    System.out.print("Prioritat a mostrar: baixa/mitjana/alta: ");
                    prioritat = scanner.nextLine().toLowerCase();
                    gestor.mostrarTasquesPerPrioritat(prioritat);
                    break;
                case 6:
                    gestor.sortir();
                    break;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        }
    }
}
                    
                    
                    
                    
                    
                    
                    
            
            
            







