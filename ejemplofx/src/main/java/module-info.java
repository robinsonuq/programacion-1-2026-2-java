module co.edu.uniquindio.poo.ejemplofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens co.edu.uniquindio.poo.ejemplofx to javafx.fxml;
    exports co.edu.uniquindio.poo.ejemplofx;
    exports co.edu.uniquindio.poo.ejemplofx.maincontroller;
    opens co.edu.uniquindio.poo.ejemplofx.maincontroller to javafx.fxml;
}