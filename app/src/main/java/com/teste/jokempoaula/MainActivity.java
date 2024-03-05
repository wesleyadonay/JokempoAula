package com.teste.jokempoaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);
        TextView textJogador = findViewById(R.id.textJogador);
        TextView textCPU = findViewById(R.id.textCPU);
        textResultado.setText("Escolha uma opção abaixo:");

        int contPlacarUsuario =Integer.valueOf(textJogador.getText().toString());
        int contPlacarCPU = Integer.valueOf(textCPU.getText().toString());

        int numero = new Random().nextInt(3);
        String[] jogadas = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = jogadas[numero];

        switch (escolhaApp){
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if((escolhaApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (escolhaApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                (escolhaApp == "Papel" && opcaoSelecionada == "Pedra")){
            contPlacarCPU = contPlacarCPU + 1;
            textCPU.setText(String.valueOf(contPlacarCPU));
            if(contPlacarCPU == 9){
                textResultado.setText("Você perdeu ! ,Tente novamente");
                textJogador.setText("0");
                textCPU.setText("0");
            }
        }else if((escolhaApp == "Papel" && opcaoSelecionada == "Tesoura") ||
                (escolhaApp == "Pedra" && opcaoSelecionada == "Papel") ||
                (escolhaApp == "Tesoura" && opcaoSelecionada == "Pedra")){
            contPlacarUsuario = contPlacarUsuario + 1;
            textJogador.setText(String.valueOf(contPlacarUsuario));
            if(contPlacarUsuario == 9){
                textResultado.setText("Parabens Você venceu !");
                textJogador.setText("0");
                textCPU.setText("0");
            }
        }else{
            textResultado.setText("Empate!");
        }


    }
}