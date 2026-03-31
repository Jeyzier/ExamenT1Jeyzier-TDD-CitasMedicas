package cibertec;

public class Cliente {
    private String id;
    private boolean activo;

    public Cliente(String id, boolean activo) {
        this.id = id;
        this.activo = activo;
    }
    public boolean isActivo() { return activo; }
}
