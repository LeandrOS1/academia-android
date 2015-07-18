package joeadyz.pe.academia;

import android.widget.EditText;
import android.widget.RatingBar;

import joeadyz.pe.academia.modelo.Alumno;

/**
 * Created by Celeritech Peru on 18/07/2015.
 */
public class FormularioHelper {

    private EditText editNombre;
    private EditText editSite;
    private EditText editTelefono;
    private EditText editDireccion;
    private RatingBar ratingNota;

    public FormularioHelper(Formulario formulario){
        editNombre = (EditText) formulario.findViewById(R.id.nombre);
        editSite = (EditText) formulario.findViewById(R.id.site);
        editTelefono = (EditText) formulario.findViewById(R.id.telefono);
        editDireccion = (EditText) formulario.findViewById(R.id.direccion);

        ratingNota = (RatingBar)
                formulario.findViewById(R.id.nota);
    }

    public Alumno guardarAlumnoDeFormulario() {
        Alumno alumno = new Alumno();
        alumno.setNombre(editNombre.getText().toString());
        alumno.setSite(editSite.getText().toString());
        alumno.setDireccion(editDireccion.getText().toString());
        alumno.setTelefono(editTelefono.getText().toString());
        alumno.setNota(Double.valueOf(ratingNota.getRating()));
        return alumno;
    }

    public void colocarAlumnoEnFormulario(Alumno alumnoAModificar) {
        editNombre.setText(alumnoAModificar.getNombre());
        editSite.setText(alumnoAModificar.getSite());
        editDireccion.setText(alumnoAModificar.getDireccion());
        editTelefono.setText(alumnoAModificar.getTelefono());
        ratingNota.setRating(alumnoAModificar.getNota().floatValue());

    }
}
