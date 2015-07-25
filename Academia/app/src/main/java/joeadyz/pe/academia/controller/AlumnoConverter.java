package joeadyz.pe.academia.controller;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import joeadyz.pe.academia.modelo.Alumno;

/**
 * Created by Celeritech Peru on 25/07/2015.
 */
public class AlumnoConverter {

    public String toJSON(List<Alumno> alumnos) {
        //String datosJSON = "{\"alumnos\": [{\"nombre\": \"jose\",\"nota\": 17},{\"nombre\": \"miryan\",\"nota\": 20}]}";

        try {
            JSONStringer js = new JSONStringer();
            js.object().key("alumnos").array();

            for (Alumno alumno : alumnos) {
                js.object();
                js.key("nombre");
                js.value(alumno.getNombre());
                js.endObject();
            }

            js.endArray().endObject();

            return js.toString();

        }catch(JSONException e){
            throw  new RuntimeException(e);
        }




    }
}
