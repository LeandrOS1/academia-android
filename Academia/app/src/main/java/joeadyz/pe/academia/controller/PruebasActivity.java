package joeadyz.pe.academia.controller;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import joeadyz.pe.academia.R;
import joeadyz.pe.academia.modelo.Prueba;

public class PruebasActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pruebas);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();

        if(isTablet()){
            beginTransaction.replace(R.id.lista_pruebas_fragment, new PruebasFragment());
            beginTransaction.replace(R.id.pruebas_detalle_fragment,
                    new DetalleFragment());
        }else{
            beginTransaction.replace(R.id.unico, new PruebasFragment());
        }

        beginTransaction.commit();




    }

    private boolean isTablet() {

        return getResources().getBoolean(R.bool.inTable);
    }

    public void seleccionaPrueba(Prueba prueba) {
        Bundle argumentos = new Bundle();
        argumentos.putSerializable("prueba", prueba);

        DetalleFragment detallePrueba = new DetalleFragment();
        detallePrueba.setArguments(argumentos);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.pruebas_detalle_fragment, detallePrueba);
        transaction.addToBackStack(null);
        transaction.commit();





    }
}
