package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.EmpresaEnvios;
import co.edu.uniquindio.poo.model.Envio;
import co.edu.uniquindio.poo.model.EnvioNacional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        EmpresaEnvios empresaEnvios = new EmpresaEnvios("Envios UQ");

        EnvioNacional envioNacional1 = new EnvioNacional("001",30,
                3000,"Juan",empresaEnvios,"Pereira",true);

        envioNacional1.calcularCostoTotal();

    }
}
