import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControlDeRobot extends Application {         //Definim la classe publica ControlDeRobot i extrendra a Application per ver la apliació JavaFX.
    private int x = 0;                                    //Declarem les variables de posició x/y i les inicialitzem amb valor 0. 
    private int y = 0;
    private String direccioInicial_Final = "";            //Declarem la variable per la direcció i la declarem buida per tal de després afegir la direcció.
    private Label estat;                                  //La variable estat s'utilitzara per printar en l'aplicació la posició i la direcció.

    public void start(Stage finestraPrincipal) {
        Button boto_Endavant = new Button("Moure Endavant");               //Creeem els botons per controlar el robot.
        Button boto_Enrere = new Button("Moure Enrere");
        Button boto_Esquerra = new Button("Girar Esquerra");
        Button boto_Dreta = new Button("Girar Dreta");
        Button boto_guardarEstat = new Button("Guardar Estat");
        Button boto_carregarEstat = new Button("Carregar Estat");

        estat = new Label(getEstat());                                   //Creem l'etiqueta per després mostrar l'estat del robot.

        boto_Endavant.setOnAction(e -> moureRobot_endavant());           //Assignem les accions als botons que hem creat abans, les accions cridaran als metodes.
        boto_Enrere.setOnAction(e -> moureRobot_enrere());
        boto_Esquerra.setOnAction(e -> girarRobot("esquerra"));
        boto_Dreta.setOnAction(e -> girarRobot("dreta"));
        boto_guardarEstat.setOnAction(e -> guardarEstat());
        boto_carregarEstat.setOnAction(e -> carregarEstat());

        VBox layout = new VBox(10);                                     //Creem amb el VBox una caixa vertical i li dorarem espai entre ellsi el padding.
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        HBox botons_robot_moviment = new HBox(20, boto_Endavant, boto_Enrere, boto_Esquerra, boto_Dreta);     //Creem amb el HBox dues caixes horitzontals amb els botons del layout.
        botons_robot_moviment.setAlignment(Pos.CENTER);

        HBox botons_robot_estat = new HBox(20, boto_guardarEstat, boto_carregarEstat);                        //Creem amb el HBox dues caixes horitzontals amb els botons del layout.
        botons_robot_estat.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(estat, botons_robot_moviment, botons_robot_estat);                        //Afegim l'etiqueta d'estat i les HBox amb els botons del layout.

        Scene escena = new Scene(layout, 800, 400);                     //Creem l'escena i fiquem les dimensions i posem el titol de la finestra.
        finestraPrincipal.setTitle("Control del Robot");
        finestraPrincipal.setScene(escena);
        finestraPrincipal.show();
    }

    private void moureRobot_endavant() {                  //S'activara al apretar el boto moure endavant
        if (this.direccioInicial_Final.isEmpty()) {      //Si la direcció esta buida asignara Nord per predeterminat
            this.direccioInicial_Final = "Nord";
        }
        switch (this.direccioInicial_Final) {     //Utilitzarem el switch per tal de incrementar o decrementar les coordenades.
            case "Nord":
                y++;
                break;
            case "Sud":
                y--;
                break;
            case "Est":
                x++;
                break;
            case "Oest":
                x--;
                break;
            default:
                break;
        }
        Estat();                             //Cada vegada que fara el switch cridara al Estat per printar la direcció i les coordenades.
    }
    
    private void moureRobot_enrere() {                     //S'activara al apretar el boto moure enrere
        if (this.direccioInicial_Final.isEmpty()) {        //Si la direcció esta buida asignara Nord per predeterminat
            this.direccioInicial_Final = "Nord";
        }
        switch (this.direccioInicial_Final) {              //Utilitzarem el switch per tal de incrementar o decrementar les coordenades.
            case "Nord":
                y--;
                break;
            case "Sud":
                y++;
                break;
            case "Est":
                x--;
                break;
            case "Oest":
                x++;
                break;
            default:
                break;
        }
        Estat();                                          //Cada vegada que fara el switch cridara al Estat per printar la direcció i les coordenades.
    }  

    private void girarRobot(String direccio) {            //S'activara al apretar el boto girar_esquerra o girar_dreta
        switch (direccio) {
            case "esquerra":                              //Si apretem el boto esquerra aniram canviant de direcció cada vegada que l'apretem una vegada.
            switch (this.direccioInicial_Final) {         //Verifica la direcció inicial del robot
                case "Nord":
                    this.direccioInicial_Final = "Oest";
                    break;
                case "Sud":
                    this.direccioInicial_Final = "Est";
                    break;
                case "Est":
                    this.direccioInicial_Final = "Nord";
                    break;
                case "Oest":
                    this.direccioInicial_Final = "Sud";
                    break;
                default:
                    break;
            }
                break;

            case "dreta":                                   //Si apretem el boto dreta aniram canviant de direcció cada vegada que l'apretem una vegada.
            switch (this.direccioInicial_Final) {           //Verifica la direcció inicial del robot
                case "Nord":
                    this.direccioInicial_Final = "Est";
                    break;
                case "Sud":
                    this.direccioInicial_Final = "Oest";
                    break;
                case "Est":
                    this.direccioInicial_Final = "Sud";
                    break;
                case "Oest":
                    this.direccioInicial_Final = "Nord";
                    break;
                default:
                    break;
            }
                break;

        }
        Estat();                                             //Actualitza l'estat del robot
    }

    private void Estat() {              //Metode per actualitzar l'estat del robot
        estat.setText(getEstat());
    }

    private String getEstat() {         //Metode per printar les dades a la aplicació
        return "**********  MENU  ***********\n Estat del robot: (" + x + "," + y + ") Direcció: " + direccioInicial_Final;
    }

    private void guardarEstat() {         //Metode per guardar l'estat del robot.
        try (PrintWriter out = new PrintWriter(new FileWriter("coordenades_robot.txt"))) {    //Guardarem l'estat del robot al arxiu coordenades_robot.txt
            out.println(x + "," + y + "," + direccioInicial_Final);                           //Guardarem les coordenades separades per comes a l'arxiu.
            Alert alerta = new Alert(AlertType.INFORMATION);                                  //Rebrem una alerta quan s'hagi guardat.
            alerta.setContentText("Estat del robot guardat");
            alerta.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarEstat() {         //Metode per carregar l'estat del robot.
        try (BufferedReader in = new BufferedReader(new FileReader("coordenades_robot.txt"))) {     //Carregarem l'estat de l'arxiu coordenades_robot.txt
            String[] estat = in.readLine().split(",");            //Dividirem la linea per comes per obtenir les dades.
            x = Integer.parseInt(estat[0]);
            y = Integer.parseInt(estat[1]);
            direccioInicial_Final = estat[2];                 
            Estat();                                              //Actualitzarem l'estat amb les dades lleguides.
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setContentText("Estat del robot carregat");    //Rebrem una alerta quan shago carregat.
            alerta.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
