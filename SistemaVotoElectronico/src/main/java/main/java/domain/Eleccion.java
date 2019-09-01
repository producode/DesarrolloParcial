package main.java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Eleccion {
    private List<Lista> listas = new ArrayList<>();
    private List<Boleta> boletas = new ArrayList<>();
    private List<Votante> votantes = new ArrayList<>();
    private List<RecuentoPartidoAlianza> votos = new ArrayList<>();

    public Votante getVotante(int DNI) {
        return votantes.stream().filter(v -> v.getDNI() == DNI).collect(Collectors.toList()).get(0);
    }

    public void AgregarLista(Lista lista){
        RecuentoPartidoAlianza nuevoRecuento = new RecuentoPartidoAlianza();
        if(lista.getPartidoPolitico() != null){
            nuevoRecuento.RecuentoPartidoPolitico(lista.getPartidoPolitico(),0);
        }
        else{
            nuevoRecuento.RecuentoAlianza(lista.getAlianza(),0);
        }
        this.listas.add(lista);
        this.votos.add(nuevoRecuento);
    }

    public void CrearVotante(String nombre,int edad,int DNI){
        Votante nuevoVotante = new Votante();
        nuevoVotante.setNombre(nombre);
        nuevoVotante.setDNI(DNI);
        nuevoVotante.getEdad(edad);
        this.votantes.add(nuevoVotante);
    }

    public int CandidadDeListas(){
        return this.listas.size();
    }

    public IntStream CantidadDeCandidatos(int listaNumero){
        return this.listas.stream().filter(v -> v.getNumero() == listaNumero).collect(Collectors.toList()).stream().mapToInt(v -> v.CantidadDePostulantes());
    }

    public int getNumeroLista(){
        return this.listas.size() + 1;
    }

    public void agregarVoto(Votante voto){
        boletas.add(voto.introducirVoto());
    }

    public Lista getLista(String nombre){
        return this.listas.stream().filter(v -> v.getNombre().equals(nombre)).collect(Collectors.toList()).get(0);
    }

    public Persona getCandidato(String nombreLista, String nombreCandidato){
        return getLista(nombreLista).getCandidatos().stream().filter(v -> v.getNombre().equals(nombreCandidato)).collect(Collectors.toList()).get(0);
    }

    public List<RecuentoPartidoAlianza> getVotos(){
        ContarVotos();
        List<RecuentoPartidoAlianza> recuentoAuxiliar = new ArrayList<>();

        recuentoAuxiliar
                .stream()
                .filter(recuento -> recuento.getPartidoPolitico() != null)
                .collect(Collectors.toList())
                .forEach(partido ->
                        partido.sumarVotos(
                                listas
                                        .stream()
                                        .filter(lista -> lista.getPartidoPolitico() == partido.getPartidoPolitico())
                                        .collect(Collectors.toList()).get(0).getCantidadVotos())
                );
        recuentoAuxiliar
                .stream()
                .filter(recuento -> recuento.getAlianza() != null)
                .collect(Collectors.toList())
                .forEach(partido ->
                        partido.sumarVotos(
                                listas
                                        .stream()
                                        .filter(lista -> lista.getAlianza() == partido.getAlianza())
                                        .collect(Collectors.toList()).get(0).getCantidadVotos())
                );
        return recuentoAuxiliar;

    }

    private void ContarVotos() {
        boletas.forEach(boleta ->
                boleta.candidatoVotado.forEach(persona ->
                        listas.forEach(lista ->
                                lista.agregarVoto(lista.getCandidatos().stream().filter(candidato -> candidato.getNombre().equals(persona.getNombre())).count())
                                )
                        )
                );
    }
}
