package main.java.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Votante {
    private String nombre;
    private int Edad;
    private int DNI;
    private Boleta voto;

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setEdad(int edadIngresada) {
        Edad = edadIngresada;
    }

    public void setNombre(String nombreIngresado) {
        this.nombre = nombreIngresado;
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad(int edad) {
        return Edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarListaCompleta(Lista lista){
        this.voto.candidatoVotado = lista.getCandidatos();
    }

    public void agregarCandidato(Persona candidato){
        if(this.voto.candidatoVotado.stream().filter(v -> v.getCargo() == candidato.getCargo()).count() >= 1 && candidato.getCargo() == cargo.PRESIDENTE){
            System.console().printf("no puede votar dos veces a una persona para presidente");
        }
        else if(this.voto.candidatoVotado.stream().filter(v -> v.getCargo() == candidato.getCargo()).count() >= 1 && candidato.getCargo() == cargo.VICEPRESIDENTE){
            System.console().printf("no puede votar dos veces a una persona para vicepresidente");
        }
        else {
            this.voto.candidatoVotado.add(candidato);
        }
    }

    public Boleta introducirVoto(){
        Boleta temporal = this.voto;
        this.voto = null;
        return temporal;
    }
}
