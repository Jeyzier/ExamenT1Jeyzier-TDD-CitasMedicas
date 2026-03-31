package cibertec;


public class RegistroCitas {

    public String registrarCita(String codigo, String nombrePaciente, String numeroDocumento, String fechaCita) {


        if (codigo == null || !codigo.matches("^C\\d{3}$")) {
            return "Ingrese un código de cita válido";
        }

        String nombreSinEspacios = nombrePaciente != null ? nombrePaciente.replace(" ", "") : "";

        // Validamos que solo tenga letras (y espacios) y que tenga al menos 5 letras
        if (nombrePaciente == null || !nombrePaciente.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$") || nombreSinEspacios.length() < 5) {
            return "El nombre del paciente debe tener al menos 5 caracteres alfabéticos";
        }

        return "Registro exitoso";
    }

}
