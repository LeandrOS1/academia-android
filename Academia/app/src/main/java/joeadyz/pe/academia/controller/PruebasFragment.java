package joeadyz.pe.academia.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import joeadyz.pe.academia.R;

/**
 * Created by Celeritech Peru on 01/08/2015.
 */
public class PruebasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View listaPruebas = inflater.inflate(R.layout.lista_pruebas, null);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
