package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class Alianza extends PartidoPolitico{
    private List<Alianza> alianzas = new ArrayList<>();
    private List<PartidoPolitico> partidoPoliticos = new ArrayList<>();

    public void AgregarAlianza(Alianza alianza){
        this.alianzas.add(alianza);
    }

    public void AgregarPartido(PartidoPolitico partidoPolitico){
        this.partidoPoliticos.add(partidoPolitico);
    }

    public List<PartidoPolitico> getPartidosPoliticos(){
        return this.partidoPoliticos;
    }

    public List<Alianza> getAlianzas(){
        return this.alianzas;
    }
}
