package co.edu.uniquindio.poo.empresa.app;


import co.edu.uniquindio.poo.empresa.model.Empleado;
import co.edu.uniquindio.poo.empresa.model.Empresa;
import co.edu.uniquindio.poo.empresa.viewcontrollers.EmpresaViewController;
import co.edu.uniquindio.poo.empresa.viewcontrollers.InicioSesionViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Aplicacion  extends Application {

    private Stage primaryStage;
    //una instancia unica solo se puede hacer una vez
    public static Empresa empresa = new Empresa("UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Empresa UQ");
        openViewLogin();
    }

    // este codigo sirve para abrir una ventana
    private void openViewLogin() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresa/iniciosesion.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            InicioSesionViewController inicioSesionViewController = loader.getController();
            inicioSesionViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // este codigo sirve para abrir una ventana
    public void openViewEmpresa() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresa/empresaview.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            EmpresaViewController empresaViewController = loader.getController();
            empresaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void inicializarData() {

        Empleado empleado1 = new Empleado
                ("Juan","Arias","1094","123456","jarias");
        empresa.registraEmpleado(empleado1);

        Empleado empleado2 = new Empleado
                ("Diana","Arias","1095","12345","darias");
        empresa.registraEmpleado(empleado2);

        Empleado empleado3 = new Empleado
                ("Maria","Arias","1096","1234","marias");
        empresa.registraEmpleado(empleado3);


    }

    public static void main(String[] args) {
        launch();
    }


}
