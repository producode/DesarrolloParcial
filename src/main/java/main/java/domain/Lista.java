package main.java.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lista {
    private List<Persona> candidatos = new ArrayList<>();
    private String nombre;
    private int numero;
    private PartidoPolitico partidoPolitico;
    private Alianza alianza;
    private long CantidadVotos;


    public long getCantidadVotos() {
        return CantidadVotos;
    }

    public Alianza getAlianza() {
        return alianza;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void CrearListaPartidoPolitico(String nombreLista, int numeroLista, PartidoPolitico partidoPoliticoLista) {
        if(partidoPolitico.ComprobarVigencia()){
            this.partidoPolitico = partidoPoliticoLista;
            this.nombre = nombreLista;
            this.numero = numeroLista;
        }
        else {
            System.console().printf("el partido no esta vigente");
            this.partidoPolitico = null;
        }
    }

    public void CrearListaAlianza(String nombreLista, int numeroLista, Alianza alianzaLista){
        this.nombre = nombreLista;
        this.numero = numeroLista;
        this.alianza = alianzaLista;
    }

    public void AgregarCandidato(Persona candidato){
        if(candidato.getCargo() == cargo.PRESIDENTE && EsElUnicoCanditoAlPuesto(cargo.PRESIDENTE)){
            this.candidatos.add(candidato);
        }
        else if(candidato.getCargo() == cargo.PRESIDENTE && EsElUnicoCanditoAlPuesto(cargo.VICEPRESIDENTE)){
            this.candidatos.add(candidato);
        }
        else if(candidato.getCargo() == cargo.PRESIDENTE || candidato.getCargo() == cargo.VICEPRESIDENTE){
            System.console().printf("ya hay un candidato para este puesto");
        }
        else {
            this.candidatos.add(candidato);
        }
    }

    public int CantidadDePostulantes(){
        return candidatos.size();
    }

    private boolean EsElUnicoCanditoAlPuesto(cargo CargoDelCandidato){
        List<Persona> candidato = this.candidatos.stream().filter(c -> c.getCargo() == CargoDelCandidato).collect(Collectors.toList());
        return candidato.size() == 0;
    }

    public List<Persona> getCandidatos() {
        return candidatos;
    }

    public void agregarVoto(long votos){
        this.CantidadVotos = this.CantidadVotos + votos;
    }
}
