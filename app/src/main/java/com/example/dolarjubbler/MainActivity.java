package com.example.dolarjubbler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dolarjubbler.entities.Dollar;
import com.example.dolarjubbler.services.DollarService;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_list, btn_history, btn_date;
    ListView listaValores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_list = findViewById(R.id.btn_listValues);
        btn_history = findViewById(R.id.btn_history);
        btn_date = findViewById(R.id.btn_date);
        listaValores = findViewById(R.id.listarValores);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DollarService ds = new DollarService(MainActivity.this);
                ds.listValues(new DollarService.ListValuesResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Hubo un error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<Dollar> dollarList) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,dollarList);
                        listaValores.setAdapter(arrayAdapter);
                    }
                });
            }
        });

        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Funcionando", Toast.LENGTH_SHORT).show();
            }
        });

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Funcionando 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}