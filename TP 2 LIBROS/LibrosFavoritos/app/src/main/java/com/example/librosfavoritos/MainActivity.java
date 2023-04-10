package com.example.librosfavoritos;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librosfavoritos.base.DbHelper;
import com.example.librosfavoritos.base.Libro;
import com.example.librosfavoritos.util.MyAdapter;

import java.util.ArrayList;

import static com.example.librosfavoritos.base.EstructuraBD.TablaContenido.CATEGORIA;
import static com.example.librosfavoritos.base.EstructuraBD.TablaContenido.NOMBRE_TABLA;


public class MainActivity extends Activity {


    private Spinner filtroFav, filtroCat;
    private RecyclerView lista;
   // private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager manager;
    private MyAdapter rvAdapter;
    final DbHelper dbHelper = new DbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rv_lista);
        manager = new LinearLayoutManager(this);
        lista.setLayoutManager(manager);
        // TODO cambiar vista
        //manager = new GridLayoutManager(this, 3);
        //lista.setLayoutManager(manager);
        filtroCat = findViewById(R.id.sp_categorias);
        filtroFav = findViewById(R.id.sp_favoritos);



        mostrarLibros(dbHelper.selectTodos());

        // Llenado de Spinners
        final ArrayList<String> listaCategorias = new ArrayList<>();
        final ArrayList<String> listaFavoritos = new ArrayList<>();
        listaFavoritos.add("Todos");
        listaFavoritos.add("Favoritos");
        listaCategorias.add("Todas");
        Cursor cursorCategorias = dbHelper.getReadableDatabase().rawQuery("SELECT DISTINCT " + CATEGORIA + " FROM " + NOMBRE_TABLA, null);

        while (cursorCategorias.moveToNext()){
            String categorias =cursorCategorias.getString(0);
            listaCategorias.add(categorias);
        }
        cursorCategorias.close();
        dbHelper.close();


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaCategorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtroCat.setAdapter(adapter);
        ArrayAdapter<String> adapterFav = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaFavoritos);
        adapterFav.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtroFav.setAdapter(adapterFav);

        filtroCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String catSeleccionada = listaCategorias.get(position);
                //Toast.makeText(getApplicationContext(), catSeleccionada, Toast.LENGTH_SHORT).show();
                if (catSeleccionada.equals("Todas")){
                    mostrarLibros(dbHelper.selectTodos());
                }else{
                    mostrarLibros(dbHelper.selectCategoria(catSeleccionada));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        filtroFav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fav = listaFavoritos.get(position);
                //Toast.makeText(getApplicationContext(), fav, Toast.LENGTH_SHORT).show();
                ArrayList<Libro> librosFav = new ArrayList<>();
                if (fav.equals("Todos")){
                    mostrarLibros(dbHelper.selectTodos());
                }else{
                    mostrarLibros(dbHelper.selectFavoritos());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public static int UPDATE_REQUEST_CODE = 1;

    public void mostrarLibros(Cursor c){
        final ArrayList<Libro> libros = new ArrayList<>();

        while (c.moveToNext()){
            Libro libro = new Libro(c);
            libros.add(libro);
        }
        c.close();
        dbHelper.close();
        MyAdapter rvAdapter = new MyAdapter(libros);
        rvAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Seleccion: " + libros.get(lista.getChildAdapterPosition(v)).getTitulo(), Toast.LENGTH_SHORT).show();
                Libro seleccionado = libros.get(lista.getChildAdapterPosition(v));
                Intent intent = new Intent(MainActivity.this, DetalleLibros.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("libro", seleccionado);
                intent.putExtras(bundle);
                startActivityForResult(intent, UPDATE_REQUEST_CODE);
            }
        });
        lista.setAdapter(rvAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            mostrarLibros(dbHelper.selectTodos());
        }
    }
}
