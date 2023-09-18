package tpo_ai_api.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String contrasena;
    private int dni;
    private int telefono;
    private String email;
    private boolean isAdmin;
    private ArrayList<Reclamo> reclamos;
    private ArrayList<Edificio> edificios;

    public Usuario() {
        super();
    }

    public Usuario(String usuario, String contrasena, int dni, int telefono, String email, boolean isAdmin, ArrayList<Reclamo> reclamos, ArrayList<Edificio> edificios) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.isAdmin = isAdmin;
        this.reclamos = reclamos;
        this.edificios = edificios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public ArrayList<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(ArrayList<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(ArrayList<Edificio> edificios) {
        this.edificios = edificios;
    }
}
