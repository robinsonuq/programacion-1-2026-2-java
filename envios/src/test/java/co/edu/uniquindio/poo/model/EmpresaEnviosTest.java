package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaEnviosTest {


    @Test
    public void registrarEnvio() {
        EmpresaEnvios empresaEnvios = new EmpresaEnvios("Envios UQ");

        Envio envio1 = new EnvioNacional(10000,"001",10,2000,"Juan",
                empresaEnvios,"Pereira",true);

       String actual = empresaEnvios.registrarEnvio(envio1);

       String esperado = "Registrado exitosamente";

       assertEquals(esperado,actual);
    }
}