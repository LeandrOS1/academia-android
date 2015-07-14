package joeadyz.pe.academia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import joeadyz.pe.academia.dao.AlumnoDAO;
import joeadyz.pe.academia.modelo.Alumno;


public class MainActivity extends ActionBarActivity {

    private ListView lista;
    private Alumno alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista  = (ListView) findViewById(R.id.lista);

        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this , "Clic short en item", Toast.LENGTH_SHORT).show()

                Alumno alumnoSeleccionado =  (Alumno)  parent.getItemAtPosition(position);

                Intent irParaFormulario = new Intent(MainActivity.this, Formulario.class);
                irParaFormulario.putExtra("alumnoSeleccionado", alumnoSeleccionado);
                startActivity(irParaFormulario);


            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                alumno  = (Alumno) parent.getItemAtPosition(position);
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarLista();
    }

    private void cargarLista() {

        AlumnoDAO dao = new AlumnoDAO(this);
        List<Alumno> alumnos = dao.getLista();
        dao.close();

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Alumno> adapter = new ArrayAdapter<Alumno>(this, layout, alumnos);

        lista.setAdapter(adapter);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Matricular");
        menu.add("Enviar un SMS");
        menu.add("Visitar Pagina Web");
        menu.add("Eliminar");
        menu.add("Ver en mapa");
        menu.add("Enviar email");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int itemSeleccionado = item.getItemId();

        switch(itemSeleccionado){
            case R.id.nuevo:
                Intent irParaFormulario = new Intent(this, Formulario.class);
                startActivity(irParaFormulario);
                break;
            default:
                break;
        }




        return super.onOptionsItemSelected(item);
    }
}
