package com.example.librosfavoritos.base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.librosfavoritos.base.BaseInicial.llenarBase;
import static com.example.librosfavoritos.base.EstructuraBD.*;

// Manejador de la base de datos

public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NOMBRE = "Biblioteca.db";

    public DbHelper(Context context){
        super(context, DB_NOMBRE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
        llenarBase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(BORRAR_TABLA);
        onCreate(db);
    }

    // Mostrar todos los libros
    public Cursor selectTodos(){
        return getReadableDatabase()
                .query(
                        TablaContenido.NOMBRE_TABLA,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                );
    }

    // Filtrar por favoritos
    public Cursor selectFavoritos(){
        return getWritableDatabase()
                .query(
                        TablaContenido.NOMBRE_TABLA,
                        null,
                        TablaContenido.FAVORITO + " like ?",
                        new String[] {"SI"},
                        null,
                        null,
                        null
                );
    }

    // Filtrar por categoría
    public Cursor selectCategoria(String categoria){
        return getReadableDatabase()
                .query(
                        TablaContenido.NOMBRE_TABLA,
                        null,
                        TablaContenido.CATEGORIA + " like ?",
                        new String[] {categoria},
                        null,
                        null,
                        null
                );
    }

    public Cursor getLibroById(String id) {
        return getReadableDatabase().query(
                TablaContenido.NOMBRE_TABLA,
                null,
                TablaContenido._ID + " LIKE ?",
                new String[]{id},
                null,
                null,
                null);
    }

    public int updateLibro(Libro libro, String id) {
        return getWritableDatabase().update(
                TablaContenido.NOMBRE_TABLA,
                libro.toContentValues(),
                TablaContenido._ID + " LIKE ?",
                new String[]{id}
        );
    }

}
