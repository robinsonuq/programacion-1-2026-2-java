package co.edu.uniquindio.poo.empresa.controller;

import co.edu.uniquindio.poo.empresa.model.Empleado;
import co.edu.uniquindio.poo.empresa.model.Empresa;

public class InicioSesionController {

    Empresa empresa;

    public InicioSesionController(Empresa empresa){
        this.empresa = empresa;
    }

    // van todos los servicios relacionado con el login

    public boolean verifiarUsuario(Empleado empleado){
        return empresa.verificarUsuario(empleado);
    }

}
