package joeadyz.pe.academia.controller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import joeadyz.pe.academia.R;
import joeadyz.pe.academia.modelo.Prueba;

public class PruebasActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_pruebas);

        ListView listaDePruebas = (ListView) findViewById(R.id.pruebas);

        Prueba prueba1 = new Prueba("31/07/2015", "Spring");
        prueba1.setTopicos(Arrays.asList("Spring MVC", "Spring JDBC",
                "Spring JMS"));

        Prueba prueba2 = new Prueba("01/08/2015", "OCJP7");
        prueba2.setTopicos(Arrays.asList("POO", "Hilos",
                "JDBC"));

        List<Prueba> pruebas = Arrays.asList(prueba1, prueba2);

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Prueba> adapter = new ArrayAdapter<Prueba> (this,
                layout, pruebas);
        listaDePruebas.setAdapter(adapter);





    }

}
