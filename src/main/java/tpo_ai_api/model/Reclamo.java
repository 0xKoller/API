package tpo_ai_api.model;

import java.util.ArrayList;
import java.util.Date;

public class Reclamo {
    private int id;
    private int idUsuario;
    private int idInstalacion;
    private String descripcion;
    private ArrayList<Object> fotos;
    private EstadoReclamo estado;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public Reclamo() {
        super();
    }

    public Reclamo(int idUsuario, int idInstalacion, String descripcion, ArrayList<Object> fotos, EstadoReclamo estado, Date fechaCreacion, Date fechaModificacion) {
        this.idUsuario = idUsuario;
        this.idInstalacion = idInstalacion;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Object> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Object> fotos) {
        this.fotos = fotos;
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idInstalacion=" + idInstalacion +
                ", descripcion='" + descripcion + '\'' +
                ", fotos=" + fotos +
                ", estado=" + estado +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}
