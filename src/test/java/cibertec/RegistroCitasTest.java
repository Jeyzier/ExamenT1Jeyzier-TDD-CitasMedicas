package cibertec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroCitasTest {

    @Test
    void testRegistrarCita_CodigoInvalido() {
        RegistroCitas registro = new RegistroCitas();
        String resultado = registro.registrarCita("A123", "Juan Perez", "12345678", "2026-12-31");
        System.out.println("El mensaje devuelto fue: " + resultado);
        assertEquals("Ingrese un código de cita válido", resultado);

        String resultado1 = registro.registrarCita("C123", "Juan Perez", "12345675", "2025-12-31");
        System.out.println("El mensaje devuelto fue: " + resultado1);
        assertEquals("Registro exitoso", resultado1);
    }
}