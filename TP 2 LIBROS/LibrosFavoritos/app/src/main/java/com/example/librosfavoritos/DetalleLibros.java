package com.example.librosfavoritos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.librosfavoritos.base.DbHelper;
import com.example.librosfavoritos.base.Libro;

public class DetalleLibros extends AppCompatActivity {

    private ImageView fotoLibro;
    private TextView titulo, autor, editorial, paginas, fecha, sinopsis, idioma, categoria;
    private ImageButton favorito;
    private Libro libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libros);

        fotoLibro = findViewById(R.id.detImagen);
        titulo = findViewById(R.id.detTitulo);
        autor = findViewById(R.id.detAutor);
        editorial = findViewById(R.id.detEditorial);
        paginas = findViewById(R.id.detPag);
        fecha = findViewById(R.id.detFecha);
        sinopsis = findViewById(R.id.detSinopsis);
        idioma = findViewById(R.id.detIdioma);
        categoria = findViewById(R.id.detCat);
        favorito = findViewById(R.id.ibEstrella);

        Bundle objetoEnviado = getIntent().getExtras();
        this.libro = null;

        if (objetoEnviado != null){
            libro = (Libro) objetoEnviado.getSerializable("libro");
            fotoLibro.setImageResource(libro.getImagenUri());
            titulo.setText(libro.getTitulo());
            autor.setText(libro.getAutor());
            editorial.setText(libro.getEditorial());
            paginas.setText(libro.getPaginas());
            fecha.setText(libro.getFecha());
            sinopsis.setText(libro.getSinopsis());
            idioma.setText(libro.getIdioma());
            categoria.setText(libro.getCategoria());
            String fav = libro.getFavorito();
            if (fav.equals("SI")){
                favorito.setImageResource(R.drawable.estrella);
            }else {
                favorito.setImageResource(R.drawable.estrellavacia);
            }
        }

    }

    public void setFavorito(View view){
        //Toast.makeText(this, "d",Toast.LENGTH_SHORT).show();
        String Id = String.valueOf(libro.getId());
        String fav = libro.getFavorito();
        if (fav.equals("SI")){
            libro.setFavorito("NO");
            favorito.setImageResource(R.drawable.estrellavacia);
            setResult(RESULT_OK);
        }else{
            libro.setFavorito("SI");
            favorito.setImageResource(R.drawable.estrella);
            setResult(RESULT_OK);
        }
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        dbHelper.updateLibro(libro, Id);
    }
/*
    public void onBackPressed(){
        setResult(RESULT_CANCELED);
    }*/
}
