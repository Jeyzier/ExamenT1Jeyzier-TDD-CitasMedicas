package cibertec;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistroOrdenesTest {
    @Mock
    ClienteRepository clienteRepository; // Simulamos la BD

    @Mock
    ProductoRepository productoRepository; // Simulamos la BD

    @InjectMocks
    RegistroOrdenes registroOrdenes;

    @Test
    void testRegistrarOrden_Exitosa_ConDescuento() {
        // Preparación (Simulamos lo que devolverían las BD)
        Cliente clienteActivo = new Cliente("C001", true);
        when(clienteRepository.buscarPorId("C001")).thenReturn(clienteActivo);

        Producto laptop = new Producto("P001", 600.0, 5); // Cuesta 600, hay 5 en stock
        when(productoRepository.buscarPorId("P001")).thenReturn(laptop);

        // Pedimos 1 laptop
        Map<String, Integer> items = new HashMap<>();
        items.put("P001", 1);

        // Ejecución
        String resultado = registroOrdenes.registrarOrden("C001", items);

        // Verificación
        assertTrue(resultado.contains("OR-0001"));
        assertTrue(resultado.contains(LocalDate.now().toString()));
        assertTrue(resultado.contains("Total: 540.0")); // 600 - 10% de descuento
    }
}