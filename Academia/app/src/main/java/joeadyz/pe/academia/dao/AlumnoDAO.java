package joeadyz.pe.academia.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import joeadyz.pe.academia.modelo.Alumno;

/**
 * Created by Celeritech Peru on 11/07/2015.
 */
public class AlumnoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "Academia";
    private static final int VERSION = 1;

    public AlumnoDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Alumnos (id INTEGER PRIMARY KEY, "
                + "nombre TEXT UNIQUE NOT NULL," + "telefono TEXT, "
                + "direccion TEXT," + "site TEXT," + "foto TEXT,"
                + "nota REAL);";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String ddl = "DROP TABLE IF EXISTS Alumnos";
        db.execSQL(ddl);

        this.onCreate(db);
    }

    public List<Alumno> getLista() {
        String[] columnas = { "id", "nombre", "site", "telefono", "direccion",
                "foto", "nota" };
        Cursor cursor = getWritableDatabase().query("Alumnos", columnas, null,
                null, null, null, null);
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        while (cursor.moveToNext()) {
            Alumno alumno = new Alumno();
            alumno.setId(cursor.getLong(0));
            alumno.setNombre(cursor.getString(1));
            alumno.setSite(cursor.getString(2));
            alumno.setTelefono(cursor.getString(3));
            alumno.setDireccion(cursor.getString(4));
            alumno.setFoto(cursor.getString(5));
            alumno.setNota(cursor.getDouble(6));

            alumnos.add(alumno);
        }
        return alumnos;
    }

    public void guardar(Alumno alumno) {

        ContentValues values = new ContentValues();
        values.put("nombre", alumno.getNombre());
        values.put("site", alumno.getSite());
        values.put("direccion", alumno.getDireccion());
        values.put("nota", alumno.getNota());
        values.put("foto", alumno.getFoto());
        values.put("telefono", alumno.getTelefono());

        getWritableDatabase().insert("Alumnos", null, values);

    }

    public void eliminar(Alumno alumno) {
        String[] args = {alumno.getId().toString()};
        getWritableDatabase().delete("Alumnos", "id=?", args);

    }


    public void modificar(Alumno alumno) {
        ContentValues values = new ContentValues();
        values.put("nombre", alumno.getNombre());
        values.put("site", alumno.getSite());
        values.put("direccion", alumno.getDireccion());
        values.put("nota", alumno.getNota());
        values.put("foto", alumno.getFoto());
        values.put("telefono", alumno.getTelefono());

        String[] args = {alumno.getId().toString()};
        getWritableDatabase().update("Alumnos", values, "id=?", args);


    }







}
