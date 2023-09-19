package tpo_ai_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Unidad")
public class Unidad extends Instalacion {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 @Column(name = "estado", nullable = false, length = 50)
    private EstadoUnidad estado;
    private int idDueno;
    private int idInquilino;

    public Unidad() {
        super();
    }

    public Unidad(int piso, int numero, EstadoUnidad estado, int idDueno, int idInquilino) {
        super(piso, numero);
        this.estado = estado;
        this.idDueno = idDueno;
        this.idInquilino = idInquilino;
    }

    public EstadoUnidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoUnidad estado) {
        this.estado = estado;
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "estado=" + estado +
                ", idDueno=" + idDueno +
                ", idInquilino=" + idInquilino +
                '}';
    }
}
