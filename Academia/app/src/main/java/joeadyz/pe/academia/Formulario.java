package joeadyz.pe.academia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import joeadyz.pe.academia.modelo.Alumno;


public class Formulario extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);



        Intent intent = getIntent();
        final Alumno alumnoModificar = (Alumno)intent.getSerializableExtra("alumnoSeleccionado");


        Button boton = (Button) findViewById(R.id.boton);

        if(alumnoModificar!=null){
            boton.setText("Modificar");
            //colocamos los datos del alumno en el formulario
            //colocamos los datos del alumno en el formulario
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //codigo para guardar nuevo o editar alumno


            }
        });


    }


}
