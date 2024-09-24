package com.example.appandroidtp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.LinkedList;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cuestionario extends AppCompatActivity {

    LinkedList<Pregunta> preguntas;
    RadioButton rButton1,rButton2,rButton3,rButton4;
    TextView txtPreguntaNumero,txtPreguntaCompleta, textViewTuPuntaje;
    Button btnConfirmar;
    String nombreRecibido;
    int nPregunta = 0;
    int puntajeFinal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuestionario);

        preguntas = new LinkedList<>();

        preguntas.add(new Pregunta("¿Quién es el jugador latino que ha anotado más goles en la historia de los mundiales?",
                new String[]{
                        "Ronaldo Nazario (Brasil)",
                        "Gabriel Batistuta (Argentina)",
                        "Diego Maradona (Argentina)",
                        "Lionel Messi (Argentina)"}, 0));

        preguntas.add(new Pregunta("¿Cómo se llamó la mascota de la Copa Mundial de 1982 en España?",
                new String[]{
                        "Zakumi",
                        "Fuleco",
                        "Pique",
                        "Naranjito"}, 3));

        preguntas.add(new Pregunta("¿En qué año se celebró la primera Copa Mundial de Fútbol?",
                new String[]{
                        "1930",
                        "1960",
                        "1956",
                        "1938"}, 0));

        preguntas.add(new Pregunta("¿Dónde se disputó la Copa Mundial de 1998?",
                new String[]{
                        "Italia",
                        "Francia",
                        "Estados Unidos",
                        "Alemania"}, 1));


        rButton1 = findViewById(R.id.rButton1);
        rButton2 = findViewById(R.id.rButton2);
        rButton3 = findViewById(R.id.rButton3);
        rButton4 = findViewById(R.id.rButton4);

        txtPreguntaNumero = findViewById(R.id.txtPreguntaNumero);
        txtPreguntaCompleta = findViewById(R.id.txtPreguntaCompleta);
        textViewTuPuntaje = findViewById(R.id.textViewTuPuntaje);

        btnConfirmar = findViewById(R.id.btnConfirmar);
        Intent i = getIntent();
        nombreRecibido = i.getStringExtra("mensaje_key");
        textViewTuPuntaje.setText("Tus Puntos: " + puntajeFinal);



        mostrarPregunta();
    }


    public void mostrarPregunta(){
        if(nPregunta<preguntas.size()){
            Pregunta preguntaActual = preguntas.get(nPregunta);
            txtPreguntaNumero.setText("Pregunta " + (nPregunta + 1));
            txtPreguntaCompleta.setText(preguntaActual.getPregunta());
            String[] opciones = preguntaActual.getOpciones();

            rButton1.setText(opciones[0]);
            rButton2.setText(opciones[1]);
            rButton3.setText(opciones[2]);
            rButton4.setText(opciones[3]);

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);
        }else{
            Intent i = new Intent(this, actividad2.class);
            i.putExtra("mensaje_key",nombreRecibido);
            i.putExtra("puntos",puntajeFinal);
            startActivity(i);
        }
    }


    public void avanzar(View view){
        if (rButton1.isChecked() || rButton2.isChecked() || rButton3.isChecked() || rButton4.isChecked()) {
            Pregunta preguntaActual = preguntas.get(nPregunta);
            if (
                    (rButton1.isChecked() && preguntaActual.getRespuestaCorrecta() == 0) ||
                    (rButton2.isChecked() && preguntaActual.getRespuestaCorrecta() == 1) ||
                    (rButton3.isChecked() && preguntaActual.getRespuestaCorrecta() == 2) ||
                    (rButton4.isChecked() && preguntaActual.getRespuestaCorrecta() == 3)) {
                puntajeFinal++;
            }
            nPregunta++;
            mostrarPregunta();
            textViewTuPuntaje.setText("Tus Puntos: " + puntajeFinal);
        } else {
            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();
        }


    }


}