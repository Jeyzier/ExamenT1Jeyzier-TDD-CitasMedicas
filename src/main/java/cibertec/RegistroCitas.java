package cibertec;


public class RegistroCitas {

    public String registrarCita(String codigo, String nombrePaciente, String numeroDocumento, String fechaCita) {


        if (codigo == null || !codigo.matches("^C\\d{3}$")) {
            return "Ingrese un código de cita válido";
        }

        return "Registro exitoso";
    }

}
