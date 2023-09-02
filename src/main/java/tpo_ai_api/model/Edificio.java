package tpo_ai_api.model;

import javax.persistence.*;

@Entity
@Table(name = "edificio_tabla")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_col", nullable = false, length = 50)
    private String nombre;
    private Direccion direccion;

    public Edificio(){ super(); }
    public Edificio(String nombre, Direccion direccion) {
        super();
        this.nombre = nombre;
        this.direccion = direccion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
