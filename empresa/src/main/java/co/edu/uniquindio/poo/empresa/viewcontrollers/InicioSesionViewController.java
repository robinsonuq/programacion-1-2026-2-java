package co.edu.uniquindio.poo.empresa.viewcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresa.app.Aplicacion;
import co.edu.uniquindio.poo.empresa.controller.InicioSesionController;
import co.edu.uniquindio.poo.empresa.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioSesionViewController {


    private InicioSesionController inicioSesionController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsuario;

    private Aplicacion aplicacion;

    @FXML
    void iniciarSesionEvent(ActionEvent event) {

         iniciarSesionAction();
    }

    private void iniciarSesionAction() {

        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        boolean verificado = verificarDatos(usuario,password);
        if(verificado){
            Empleado empleado = new Empleado("","","",password,usuario);
           boolean identificado = inicioSesionController.verifiarUsuario(empleado);
           if(identificado){
               mostrarMensaje("Usuario autorizado","Datos validos", Alert.AlertType.INFORMATION);
              aplicacion.openViewEmpresa();
           }else{
               mostrarMensaje("Usuario no autorizado","Datos invalidos", Alert.AlertType.WARNING);
           }

        }else{
            mostrarMensaje("Error","Datos incorrectos", Alert.AlertType.WARNING);
        }

    }

    private boolean verificarDatos(String usuario, String password) {

        if(usuario.trim().isEmpty() || password.trim().isEmpty()){
            return false;
        }
        return true;
    }

    public void mostrarMensaje(String titulo,String mensaje,Alert.AlertType alertType) {
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setApp(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        inicioSesionController = new InicioSesionController(aplicacion.empresa);
    }


    @FXML
    void initialize() {
        assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'iniciosesion.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'iniciosesion.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'iniciosesion.fxml'.";

    }

}

