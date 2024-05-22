
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage finestraPrincipal) {                  //Finestra principal amb titol AppJavaFX, on creem un boto que digui Clica i farem que al clicar truqui al metode missatge. 
        Button boto = new Button("Clica");
        boto.setOnAction(e -> missatge());
        StackPane pulsador = new StackPane(boto);
        Scene finestra = new Scene(pulsador, 500, 200);

        finestraPrincipal.setTitle("AppJavaFX");
        finestraPrincipal.setScene(finestra);
        finestraPrincipal.show();
    }

    private void missatge() {                              //Finestra que apareixara quan li donem al boto, sortira u
        Alert missatge = new Alert(AlertType.WARNING);
        missatge.setTitle("AppJavaFX");
        missatge.setContentText("Hola");
        missatge.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
