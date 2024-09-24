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

    int nPregunta = 1;
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
                new String[]{"Ronaldo Nazario (Brasil)",
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
                        "Alemania"}, 0));


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

        if(){

        }
    }



    public void avanzar(View view){

        if(rButton1.isChecked() == false && rButton2.isChecked() == false &&
                rButton3.isChecked() == false && rButton4.isChecked() == false){
            Toast.makeText(this,"Elija una opcion ",Toast.LENGTH_SHORT).show();

        }else if(nPregunta==1){
            if(rButton1.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            textViewTuPuntaje.setText("Tus Puntos: " + puntajeFinal);


            nPregunta = nPregunta+1;
            txtPreguntaNumero.setText("Pregunta 2");
            txtPreguntaCompleta.setText("¿Cómo se llamó la mascota de la Copa Mundial de 1982 en España?");
            rButton1.setText("Juanito");
            rButton2.setText("Fuleco");
            rButton3.setText("Pique");
            rButton4.setText("Naranjito");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);

        }else if(nPregunta==2){
            if(rButton4.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            textViewTuPuntaje.setText("Tus Puntos: " + puntajeFinal);

            nPregunta = nPregunta+1;

            txtPreguntaNumero.setText("Pregunta 3");
            txtPreguntaCompleta.setText("¿En qué año se celebró la primera " +
                    "Copa Mundial de Fútbol?");

            rButton1.setText("1930");
            rButton2.setText("1928");
            rButton3.setText("1942");
            rButton4.setText("1954");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);


        }else if(nPregunta==3){
            if(rButton1.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            textViewTuPuntaje.setText("Tus Puntos: " + puntajeFinal);

            nPregunta = nPregunta+1;

            txtPreguntaNumero.setText("Pregunta 4");
            txtPreguntaCompleta.setText("¿Dónde se disputó la Copa Mundial de 1998?");

            rButton1.setText("Italia");
            rButton2.setText("Francia");
            rButton3.setText("Estados Unidos");
            rButton4.setText("Alemania");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);


        }else if(nPregunta==4){
            if(rButton2.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            textViewTuPuntaje.setText("Tus Puntos: " + puntajeFinal);

            nPregunta = nPregunta+1;

            txtPreguntaNumero.setText("Pregunta 5");
            txtPreguntaCompleta.setText("¿Quién fue el jugador que marcó el gol que le dio el triunfo a " +
                    "España en la final de la Copa del Mundo del 2010 en Sudáfrica?");

            rButton1.setText("Andrés Iniesta");
            rButton2.setText("David Villa");
            rButton3.setText("Raúl González");
            rButton4.setText("Sergio Ramos");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);

        }else if(nPregunta==5){
            if(rButton1.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }
                Intent i = new Intent(this, actividad2.class);
                i.putExtra("mensaje_key",nombreRecibido);
                i.putExtra("puntos",puntajeFinal);
                startActivity(i);


        }



    }


}