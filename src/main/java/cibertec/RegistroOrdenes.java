package cibertec;

import java.time.LocalDate;
import java.util.Map;

public class RegistroOrdenes {
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;
    private int correlativo = 1;

    public RegistroOrdenes(ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    public String registrarOrden(String clienteId, Map<String, Integer> items) {
        // 1. Validar que el cliente exista y esté activo
        Cliente cliente = clienteRepository.buscarPorId(clienteId);
        if (cliente == null || !cliente.isActivo()) {
            return "Error: Cliente inactivo o no existe";
        }

        double total = 0.0;

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String prodId = entry.getKey();
            int cantidad = entry.getValue();

            if (cantidad <= 0) return "Error: Cantidad debe ser mayor a 0";

            Producto p = productoRepository.buscarPorId(prodId);

            if (p == null || p.getStock() < cantidad) {
                return "Error: Producto sin stock. Orden cancelada.";
            }

            total += p.getPrecio() * cantidad;
        }

        if (total > 500) {
            total = total * 0.90;
        }

        String codigoOrden = String.format("OR-%04d", correlativo++);
        String fechaActual = LocalDate.now().toString();

        return "Orden registrada: " + codigoOrden + " el " + fechaActual + ". Total: " + total;
    }
}
