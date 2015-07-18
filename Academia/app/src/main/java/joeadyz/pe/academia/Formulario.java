package joeadyz.pe.academia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import joeadyz.pe.academia.dao.AlumnoDAO;
import joeadyz.pe.academia.modelo.Alumno;


public class Formulario extends ActionBarActivity {


    private FormularioHelper formularioHelper;

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


    }


}
