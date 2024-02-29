package com.danidatos.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMacotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView botonsEstrella = findViewById(R.id.botonEstrella);
        botonsEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevaAct();
            }
        });




    }

    public void inicializarAdaptador(){
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void nuevaAct(){
        Intent intent = new Intent(this, Pagina2.class);
        intent.putExtra("mascotasLista", mascotas);
        startActivity(intent);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        Mascota mascota1 = new Mascota("Roberto", 0, R.drawable.masc1);
        mascotas.add(mascota1);
        Mascota mascota2 = new Mascota("Maria", 0, R.drawable.masc2);
        mascotas.add(mascota2);
        Mascota mascota3 = new Mascota("Juan", 0, R.drawable.masc3);
        mascotas.add(mascota3);
        Mascota mascota4 = new Mascota("Rada", 0, R.drawable.masc4);
        mascotas.add(mascota4);
        Mascota mascota5 = new Mascota("Matty", 0, R.drawable.masc5);
        mascotas.add(mascota5);
    }
    private void setSupportActionBar(Toolbar toolbar) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}