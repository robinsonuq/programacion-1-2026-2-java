package co.edu.uniquindio.poo.empresa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empresa {

    private String nombre;
    private List<Empleado> listaEmpleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String registraEmpleado(Empleado empleado){
        Optional<Empleado> empleado1 = buscarEmpleado(empleado.getIdentificacion());
        if(empleado1.isPresent()){
            return "Ya existe un empleado";
        }
        else listaEmpleados.add(empleado);
        return "Empelado registrado exitosamente";
    }

    private Optional<Empleado> buscarEmpleado(String identificacion) {
        return listaEmpleados
                .stream()
                .filter(e -> e.getIdentificacion()
                .equals(identificacion))
                .findFirst();
    }
    public boolean verificarUsuario(Empleado empleadoVerificar){
        boolean verificado = false;
        for (Empleado empleado : listaEmpleados){
            if(empleado.getUser().equals(empleadoVerificar.getUser())
            && empleado.getPassword().equals(empleadoVerificar.getPassword())){
                verificado = true;
                return  verificado;
            }
        }
        return verificado;
    }
    //firma del metodo
    public  boolean verificarUsuario2(Empleado empleadoVerificar){

        return listaEmpleados.stream()
                .anyMatch(empleado -> empleado.getUser()
                        .equals(empleadoVerificar.getUser())
                && empleado.getPassword().equals(empleadoVerificar.getPassword()));
    }




    //sobrecarga de metodos
    public boolean verificarUsuario(String user, String password){
        boolean verificado = false;

        for (Empleado empleado : listaEmpleados){
            if(empleado.getUser().equals(user)
                    && empleado.getPassword().equals(password)){
                verificado = true;
                return  verificado;
            }
        }
        return verificado;
    }


}
