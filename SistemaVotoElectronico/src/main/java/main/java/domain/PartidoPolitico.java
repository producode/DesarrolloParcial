package main.java.domain;

import java.sql.Date;

public class PartidoPolitico {
    private String nombre;
    private Date fechaConformacion;
    private boolean vigencia;

    public boolean ComprobarVigencia() {
        return vigencia;
    }

    public void RecobrarVigencia() {
        this.vigencia = true;
    }

    public void crearAgrupacion(String nombre, Date fechaConformacion, boolean vigencia){
        this.nombre = nombre;
        this.fechaConformacion = fechaConformacion;
        this.vigencia = vigencia;
    }
}
