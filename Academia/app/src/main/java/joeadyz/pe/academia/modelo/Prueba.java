package joeadyz.pe.academia.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Celeritech Peru on 01/08/2015.
 */
public class Prueba {
    private String fecha;
    private String materia;
    private String descripcion;
    private List<String> topicos = new
            ArrayList<String>();

    public Prueba(){}

    public Prueba(String fecha, String materia){
        this.fecha = fecha;
        this.materia = materia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
