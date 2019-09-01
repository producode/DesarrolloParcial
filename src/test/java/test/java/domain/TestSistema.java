package test.java.domain;

import main.java.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestSistema {
    private Eleccion eleccion2019;
    private Lista nuevaLista;
    private PartidoPolitico nuevoPartidoPolitico;
    private Persona nuevaPersona;
    @Before
    public void init(){
        nuevoPartidoPolitico.crearAgrupacion("cambiemos", Date.valueOf(LocalDate.now()), true);
        nuevaLista.CrearListaPartidoPolitico("juntos",eleccion2019.getNumeroLista(),nuevoPartidoPolitico);
        nuevaPersona.RegistrarCandidato("Mauricio Macri", cargo.PRESIDENTE);
        nuevaLista.AgregarCandidato(nuevaPersona);
        nuevaPersona.RegistrarCandidato("Manuel Angel Pichetto",cargo.VICEPRESIDENTE);
        nuevaLista.AgregarCandidato(nuevaPersona);
        nuevaPersona.RegistrarCandidato("Maria Eugenia Vidal",cargo.GOBERNADOR);
        nuevaLista.AgregarCandidato(nuevaPersona);
        eleccion2019.AgregarLista(nuevaLista);
        nuevoPartidoPolitico.crearAgrupacion("frente de todos", Date.valueOf(LocalDate.now()), true);
        nuevaLista.CrearListaPartidoPolitico("choriplaneros",eleccion2019.getNumeroLista(),nuevoPartidoPolitico);
        eleccion2019.AgregarLista(nuevaLista);
    }
    @Test
    public void agregarPartidoNoVigente() {
        nuevoPartidoPolitico.crearAgrupacion("despertar", Date.valueOf(LocalDate.now()), false);
        nuevaLista.CrearListaPartidoPolitico("partido libertario",eleccion2019.getNumeroLista(),nuevoPartidoPolitico);
        eleccion2019.AgregarLista(nuevaLista);
    }

    @Test
    public void RecobrarVigencia() {
        nuevoPartidoPolitico.crearAgrupacion("despertar", Date.valueOf(LocalDate.now()), false);
        nuevaLista.CrearListaPartidoPolitico("partido libertario",eleccion2019.getNumeroLista(),nuevoPartidoPolitico);
        nuevoPartidoPolitico.RecobrarVigencia();
        nuevaLista.CrearListaPartidoPolitico("partido libertario",eleccion2019.getNumeroLista(),nuevoPartidoPolitico);
        eleccion2019.AgregarLista(nuevaLista);
    }

    @Test
    public void VerCantidadDeCandidatos(){
        eleccion2019.CantidadDeCandidatos(1);
    }

    @Test
    public void verCantidadDeListas(){
        eleccion2019.CandidadDeListas();
    }

    @Test
    public void crearVotanteyVotar(){
        //votar por lista
        eleccion2019.CrearVotante("Manuel Garcia",25,40003456);
        Votante votar = eleccion2019.getVotante(40003456);
        votar.agregarListaCompleta(eleccion2019.getLista("juntos"));
        eleccion2019.agregarVoto(votar);
        //votar por candidato
        eleccion2019.CrearVotante("Jose Maria",20,41234567);
        votar = eleccion2019.getVotante(41234567);
        votar.agregarCandidato(eleccion2019.getCandidato("juntos","Mauricio Macri"));
        votar.agregarCandidato(eleccion2019.getCandidato("juntos","Maria Eugenia Vidal"));
        eleccion2019.agregarVoto(votar);
    }

    @Test
    public void contarVotosPartidosPoliticos(){
        List<RecuentoPartidoAlianza> votosParaCadaAgrupacion = new ArrayList<>();
        votosParaCadaAgrupacion = eleccion2019.getVotos();
        votosParaCadaAgrupacion.forEach(voto -> System.out.print(voto));
        votosParaCadaAgrupacion.forEach(voto -> System.out.print(voto));
    }
}
