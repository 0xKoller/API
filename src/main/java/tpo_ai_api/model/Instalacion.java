package tpo_ai_api.model;

public abstract class Instalacion {
    private int id;
    private int piso;
    private int numero;

    public Instalacion() {
        super();
    }

    public Instalacion(int piso, int numero) {
        this.piso = piso;
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
