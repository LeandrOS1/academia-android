package joeadyz.pe.academia;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import joeadyz.pe.academia.dao.AlumnoDAO;
import joeadyz.pe.academia.modelo.Alumno;


public class Formulario extends ActionBarActivity {


    private FormularioHelper formularioHelper;
    private String rutaArchivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);



        Intent intent = getIntent();
        final Alumno alumnoAModificar = (Alumno)intent.getSerializableExtra("alumnoSeleccionado");


        formularioHelper = new FormularioHelper(this);
        Button boton = (Button) findViewById(R.id.boton);

        if(alumnoAModificar!=null){
            boton.setText("Modificar");
            formularioHelper.colocarAlumnoEnFormulario(alumnoAModificar);
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Alumno alumno = formularioHelper.guardarAlumnoDeFormulario();

                AlumnoDAO dao = new AlumnoDAO(Formulario.this);

                if(alumnoAModificar == null){
                    dao.guardar(alumno);  //insert
                } else {
                    alumno.setId(alumnoAModificar.getId());  //modificar
                    dao.modificar(alumno);
                }


                dao.close();

                finish();  //se cierra el formulario para regresar al activity anterior


            }
        });


        ImageView foto = formularioHelper.getFoto();


        foto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent irParaCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                rutaArchivo = Environment.getExternalStorageDirectory().toString()
                        + "/" +  System.currentTimeMillis() + ".png";

                File archivo = new File(rutaArchivo);
                Uri localImagen = Uri.fromFile(archivo);


                irParaCamara.putExtra(MediaStore.EXTRA_OUTPUT, localImagen);

                startActivityForResult(irParaCamara, 123);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 123){
            if(resultCode == Activity.RESULT_OK){
                formularioHelper.cargarImagen(rutaArchivo);
            }else{
                rutaArchivo = null;
            }
        }
    }




}
