package main.java.domain;

public class Persona {
    private cargo Cargo;
    private String Nombre;

    public cargo getCargo() {
        return Cargo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void RegistrarCandidato(String nombre, cargo Cargo){
        this.Nombre = nombre;
        this.Cargo = Cargo;
    }
}
