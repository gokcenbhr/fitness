package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etBoy,etKilo;
    Button btnHesapla,btnKalori;
    TextView tvSonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBoy = findViewById(R.id.etBoy);
        etKilo = findViewById(R.id.etKilo);
        btnHesapla = findViewById(R.id.btnHesapla);
        tvSonuc = findViewById(R.id.tvSonuc);
        btnKalori=findViewById(R.id.btnKalori);

        btnHesapla.setOnClickListener(view -> {
            float boyDeger = Float.parseFloat(etBoy.getText().toString().trim());
            float kiloDeger = Float.parseFloat(etKilo.getText().toString().trim());
            boyDeger = boyDeger/100;
            float degerSonuc = kiloDeger/(boyDeger*boyDeger);
            if ( degerSonuc <= 18){
                tvSonuc.setText(degerSonuc + " "+ "Zayıfsınız");

            }
            if (degerSonuc > 19){
                tvSonuc.setText(degerSonuc+" "+"Kilonuz İdeal");
            }
            if (degerSonuc > 30){
                tvSonuc.setText(degerSonuc + " " + "Kilonuz Fazla");
            }
        });

        findViewById(R.id.btnKalori).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,kaloriActivity.class);
                startActivity(intent);
            }
        });

    }

}