package cibertec;

public class Producto {
    private String id;
    private double precio;
    private int stock;

    public Producto(String id, double precio, int stock) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
}
