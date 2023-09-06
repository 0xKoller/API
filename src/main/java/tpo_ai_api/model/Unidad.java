package tpo_ai_api.model;

public class Unidad extends Instalacion {
    private EstadoUnidad estado;
    private Usuario dueno;
    private Usuario inquilino;

    public Unidad() {
        super();
    }

    public Unidad(int piso, int numero, EstadoUnidad estado, Usuario dueno, Usuario inquilino) {
        super(piso, numero);
        this.estado = estado;
        this.dueno = dueno;
        this.inquilino = inquilino;
    }

    public EstadoUnidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoUnidad estado) {
        this.estado = estado;
    }

    public Usuario getDueno() {
        return dueno;
    }

    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }

    public Usuario getInquilino() {
        return inquilino;
    }

    public void setInquilino(Usuario inquilino) {
        this.inquilino = inquilino;
    }
}
