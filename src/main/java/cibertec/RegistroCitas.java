package cibertec;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegistroCitas {

    public String registrarCita(String codigo, String nombrePaciente, String numeroDocumento, String fechaCita) {

//Test5
        if (codigo == null || codigo.trim().isEmpty() ||
                nombrePaciente == null || nombrePaciente.trim().isEmpty() ||
                numeroDocumento == null || numeroDocumento.trim().isEmpty() ||
                fechaCita == null || fechaCita.trim().isEmpty()) {
            return "Debe ingresar todos los datos requeridos";
        }
//Test1
        if (codigo == null || !codigo.matches("^C\\d{3}$")) {
            return "Ingrese un código de cita válido";
        }
        String nombreSinEspacios = nombrePaciente != null ? nombrePaciente.replace(" ", "") : "";
//Test2
        if (nombrePaciente == null || !nombrePaciente.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$") || nombreSinEspacios.length() < 5) {
            return "El nombre del paciente debe tener al menos 5 caracteres alfabéticos";
        }
//Test3
        if (numeroDocumento == null || !numeroDocumento.matches("^\\d{8}$")) {
            return "Ingrese un número de documento válido";
        }
//Test4
        if (fechaCita == null) {
            return "La fecha de la cita debe ser posterior a la fecha actual";
        }
        try {
            LocalDate fecha = LocalDate.parse(fechaCita);
            if (!fecha.isAfter(LocalDate.now())) {
                return "La fecha de la cita debe ser posterior a la fecha actual";
            }
        } catch (DateTimeParseException e) {
            return "La fecha de la cita debe ser posterior a la fecha actual";
        }

        return "Registro exitoso";

    }
}
