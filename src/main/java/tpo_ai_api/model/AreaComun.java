package tpo_ai_api.model;

public class AreaComun extends Instalacion {
    private String nombre;

    public AreaComun() {
        super();
    }

    public AreaComun(int piso, int numero, String nombre) {
        super(piso, numero);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
