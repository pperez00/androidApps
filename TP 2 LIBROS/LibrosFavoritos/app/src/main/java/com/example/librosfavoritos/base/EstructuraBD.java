package com.example.librosfavoritos.base;

import android.provider.BaseColumns;

// Estructura de mi base de datos

public class EstructuraBD {
    private EstructuraBD(){
        // Constructor privado para evitar instanciar la clase
    }

    public static abstract class TablaContenido implements BaseColumns{
        public final static String NOMBRE_TABLA = "Libros";
        public final static String TITULO = "Titulo";
        public final static String AUTOR = "Autor";
        public final static String SINOPSIS = "Sinopsis";
        public final static String FECHA_DE_PUBLICACION = "FechaDePublicacion";
        public final static String EDITORIAL = "Editorial";
        public final static String CANTIDAD_DE_PAGINAS = "CantidadDePaginas";
        public final static String IDIOMA = "Idioma";
        public final static String CATEGORIA = "Categoria";
        public final static String IMAGEN_URI = "imagenUri";
        public final static String FAVORITO = "Favorito";

    }

    // Sentencia para crear la tabla
    protected final static String CREAR_TABLA = "create table if not exists " + TablaContenido.NOMBRE_TABLA + "("
            + BaseColumns._ID + " INTEGER PRIMARY KEY, "
            + TablaContenido.TITULO + " TEXT NOT NULL, "
            + TablaContenido.AUTOR + " TEXT NOT NULL, "
            + TablaContenido.EDITORIAL + " TEXT NOT NULL, "
            + TablaContenido.FECHA_DE_PUBLICACION + " TEXT NOT NULL, "
            + TablaContenido.CANTIDAD_DE_PAGINAS + " TEXT NOT NULL, "
            + TablaContenido.IDIOMA + " TEXT NOT NULL, "
            + TablaContenido.CATEGORIA + " TEXT NOT NULL, "
            + TablaContenido.SINOPSIS + " TEXT NOT NULL, "
            + TablaContenido.IMAGEN_URI + " INTEGER, "
            + TablaContenido.FAVORITO + " TEXT NOT NULL"
            + ")";

    // Sentencia para borrar la tabla
    protected final static String BORRAR_TABLA = "DROP TABLE IF EXISTS " + TablaContenido.NOMBRE_TABLA;


}
