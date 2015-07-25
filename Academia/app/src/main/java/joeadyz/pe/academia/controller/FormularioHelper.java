package joeadyz.pe.academia.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import joeadyz.pe.academia.R;
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
    private ImageView foto;
    private Alumno alumno;

    public FormularioHelper(Formulario formulario){
        editNombre = (EditText) formulario.findViewById(R.id.nombre);
        editSite = (EditText) formulario.findViewById(R.id.site);
        editTelefono = (EditText) formulario.findViewById(R.id.telefono);
        editDireccion = (EditText) formulario.findViewById(R.id.direccion);
        foto = (ImageView)formulario.findViewById(R.id.foto);
        ratingNota = (RatingBar)
                formulario.findViewById(R.id.nota);
        alumno = new Alumno();
    }

    public Alumno guardarAlumnoDeFormulario() {

        alumno.setNombre(editNombre.getText().toString());
        alumno.setSite(editSite.getText().toString());
        alumno.setDireccion(editDireccion.getText().toString());
        alumno.setTelefono(editTelefono.getText().toString());
        alumno.setNota(Double.valueOf(ratingNota.getRating()));
        return alumno;
    }

    public void colocarAlumnoEnFormulario(Alumno alumnoAModificar) {
        alumno = alumnoAModificar;
        editNombre.setText(alumno.getNombre());
        editSite.setText(alumno.getSite());
        editDireccion.setText(alumno.getDireccion());
        editTelefono.setText(alumno.getTelefono());
        ratingNota.setRating(alumno.getNota().floatValue());
        cargarImagen(alumno.getFoto());
    }


    //CAMARA

    public ImageView getFoto(){
        return foto;
    }


    public void cargarImagen(String rutaArchivo) {

        alumno.setFoto(rutaArchivo);

        Bitmap imagen = BitmapFactory.decodeFile(rutaArchivo);
        Bitmap imagenReducida = Bitmap.createScaledBitmap(imagen, 100, 100, true);

        foto.setImageBitmap(imagenReducida);

    }
}
