package com.example.personajes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private RadioButton hombre;
    private RadioButton mujer;
    private TextView respuesta;
    private RadioGroup radioGroup;
    private Integer[] personajes = {R.drawable.bart, R.drawable.homero, R.drawable.lisa, R.drawable.maggie, R.drawable.marge};
    private String genero = "hombre";
    private Random rnd = new Random();
    private int actual = 0;
    private MediaPlayer mp, sonido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.iv_imagen);
        hombre = findViewById(R.id.rb_hombre);
        mujer = findViewById(R.id.rb_mujer);
        respuesta = findViewById(R.id.tv_respuesta);
        radioGroup = findViewById(R.id.radioGroup);

        mp = MediaPlayer.create(this, R.raw.intro);
        mp.seekTo(0);
        mp.setLooping(true);
        mp.start();
    }

// Método para el botón siguiente
    public void siguiente(View view){
        if (respuesta.getText().toString().equals(getString(R.string.respuesta_correcta))) {
            // Reinicio los radio button
            radioGroup.clearCheck();
            // selecciono imagen al azar
            int aleatorio = rnd.nextInt(5);
            // compruebo que no toque la misma imagen
            while (aleatorio == actual){
                aleatorio = rnd.nextInt(5);
            }
            imagen.setImageResource(personajes[aleatorio]);
            actual = aleatorio; // guardo el índice actual de la imagen para no repetirla


            if (aleatorio == 0 || aleatorio == 1){
                genero = "hombre";
            }else{
                genero = "mujer";
            }
            respuesta.setText("");
        }else {
            Toast.makeText(this, R.string.mensaje, Toast.LENGTH_SHORT).show();
        }

    }

    // Método para seleccionar el género
    public void seleccion(View view){

        if(hombre.isChecked()){
            if(genero.equals("hombre")){
                respuesta.setText(R.string.respuesta_correcta);
                respuesta.setTextColor(Color.parseColor("#FF33691E"));
                getSonidoOk().start();
            }else {
                respuesta.setText(R.string.respuesta_incorrecta);
                respuesta.setTextColor(Color.RED);
                getSonidoError().start();
            }
        }
        if(mujer.isChecked()){
            if(genero.equals("mujer")){
                respuesta.setText(R.string.respuesta_correcta);
                respuesta.setTextColor(Color.parseColor("#FF33691E"));
                getSonidoOk().start();
            }else {
                respuesta.setTextColor(Color.RED);
                respuesta.setText(R.string.respuesta_incorrecta);
                getSonidoError().start();
            }
        }
    }
    // Métodos para obtener los sonidos
    public MediaPlayer getSonidoError(){
        int errores [] = {R.raw.chango, R.raw.haha, R.raw.caramba};
        Random rnd = new Random();
        int i = rnd.nextInt(3);
        if (sonido != null) {
            sonido.stop();
            sonido.release();
        }
        sonido = MediaPlayer.create(this, errores[i]);
        return sonido;
    }
    public MediaPlayer getSonidoOk(){
        int ok [] = {R.raw.burp, R.raw.cowabunga, R.raw.gracias};
        Random rnd = new Random();
        int i = rnd.nextInt(3);
        if (sonido != null) {
            sonido.stop();
            sonido.release();
        }
        sonido = MediaPlayer.create(this, ok[i]);
        return sonido;
    }

}
