package com.example.librosfavoritos.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import java.io.Serializable;

import static com.example.librosfavoritos.base.EstructuraBD.TablaContenido.*;

public class Libro implements Serializable {
    private String titulo, autor, editorial, fecha, paginas, idioma, categoria, sinopsis, favorito;
    private long id;
    private int imagenUri;

    public Libro(String titulo, String autor, String editorial, String fecha, String paginas, String idioma, String categoria, String sinopsis, int imagenUri, String favorito) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha = fecha;
        this.paginas = paginas;
        this.idioma = idioma;
        this.categoria = categoria;
        this.sinopsis = sinopsis;
        this.imagenUri = imagenUri;
        this.favorito = favorito;
    }

    // Entidad Libro

    public Libro(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID));
        titulo = cursor.getString(cursor.getColumnIndex(TITULO));
        autor = cursor.getString(cursor.getColumnIndex(AUTOR));
        editorial = cursor.getString(cursor.getColumnIndex(EDITORIAL));
        fecha = cursor.getString(cursor.getColumnIndex(FECHA_DE_PUBLICACION));
        paginas = cursor.getString(cursor.getColumnIndex(CANTIDAD_DE_PAGINAS));
        idioma = cursor.getString(cursor.getColumnIndex(IDIOMA));
        categoria = cursor.getString(cursor.getColumnIndex(CATEGORIA));
        sinopsis = cursor.getString(cursor.getColumnIndex(SINOPSIS));
        imagenUri = cursor.getInt(cursor.getColumnIndex(IMAGEN_URI));
        favorito = cursor.getString(cursor.getColumnIndex(FAVORITO));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TITULO, titulo);
        values.put(AUTOR, autor);
        values.put(EDITORIAL, editorial);
        values.put(FECHA_DE_PUBLICACION, fecha);
        values.put(CANTIDAD_DE_PAGINAS, paginas);
        values.put(IDIOMA, idioma);
        values.put(CATEGORIA, categoria);
        values.put(SINOPSIS, sinopsis);
        values.put(IMAGEN_URI, imagenUri);
        values.put(FAVORITO, favorito);
        return values;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPaginas() {
        return paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getImagenUri() {
        return imagenUri;
    }

    public String getFavorito() {
        return favorito;
    }

    public long getId() {
        return id;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }
}
