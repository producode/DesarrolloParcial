package main.java.domain;

public class RecuentoPartidoAlianza {
    private Alianza alianza = null;
    private PartidoPolitico partidoPolitico = null;
    private long votos;

    public void RecuentoAlianza(Alianza alianza, int cantidadVotos) {
        this.alianza = alianza;
        this.votos = cantidadVotos;
    }

    public void RecuentoPartidoPolitico(PartidoPolitico partidoPolitico, int cantidadVotos) {
        this.partidoPolitico = partidoPolitico;
        this.votos = cantidadVotos;
    }

    public Alianza getAlianza() {
        return alianza;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public long getVotos() {
        return votos;
    }

    public void sumarVotos(long votos){
        this.votos = this.votos + votos;
    }
}
