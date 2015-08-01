package joeadyz.pe.academia.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import joeadyz.pe.academia.R;
import joeadyz.pe.academia.modelo.Prueba;

/**
 * Created by Celeritech Peru on 01/08/2015.
 */
public class PruebasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View listaPruebas = inflater.inflate(R.layout.lista_pruebas, null);



        ListView lista = (ListView) listaPruebas.findViewById(R.id.pruebas);

        Prueba prueba1 = new Prueba("31/07/2015", "Spring");
        prueba1.setTopicos(Arrays.asList("Spring MVC", "Spring JDBC",
                "Spring JMS"));

        Prueba prueba2 = new Prueba("01/08/2015", "OCJP7");
        prueba2.setTopicos(Arrays.asList("POO", "Hilos",
                "JDBC"));

        List<Prueba> pruebas = Arrays.asList(prueba1, prueba2);

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Prueba> adapter = new ArrayAdapter<Prueba> (getActivity(),
                layout, pruebas);
        lista.setAdapter(adapter);



        return listaPruebas;
    }
}
