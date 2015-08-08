package joeadyz.pe.academia.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import joeadyz.pe.academia.R;
import joeadyz.pe.academia.modelo.Prueba;


/**
 * Created by Celeritech Peru on 01/08/2015.
 */
public class DetalleFragment extends Fragment {

    private Prueba prueba;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.prueba_detalle, null);

        if(getArguments()!=null){
            this.prueba = (Prueba) getArguments().getSerializable("prueba");
        }

        if(this.prueba!=null){
            TextView materia = (TextView)layout.findViewById(R.id.detalle_prueba_materia);
            TextView fecha = (TextView)layout.findViewById(R.id.detalle_prueba_fecha);
            ListView topicos = (ListView)layout.findViewById(R.id.detalle_prueba_topicos);

            materia.setText(this.prueba.getMateria());
            fecha.setText(this.prueba.getFecha());

            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(
                            getActivity(),
                            android.R.layout.simple_list_item_1,
                            prueba.getTopicos());

            topicos.setAdapter(adapter);
            return layout;
        }




        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
