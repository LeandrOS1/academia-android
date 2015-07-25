package joeadyz.pe.academia.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import joeadyz.pe.academia.dao.AlumnoDAO;
import joeadyz.pe.academia.modelo.Alumno;

/**
 * Created by Celeritech Peru on 25/07/2015.
 */
public class EnviaAlumnosTask extends AsyncTask<Integer, Double, String> {
    private final Activity context;
    private ProgressDialog progressDialog;


    public EnviaAlumnosTask(Activity context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(context, "Cargando Alumnos",
                "Trayendo datos del servidor", true, true);
    }

    @Override
    protected String doInBackground(Integer... params) {
        String urlServidor = "http://api.joedayz.pe/android-mooc/api/v1.0/notas";

        AlumnoDAO dao = new AlumnoDAO(context);
        List<Alumno> alumnos = dao.getLista();
        dao.close();

        String datosJSON = new AlumnoConverter().toJSON(alumnos);

        WebClient client = new WebClient(urlServidor);
        final String respuestaJSON = client.post(datosJSON);

        return respuestaJSON;
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
