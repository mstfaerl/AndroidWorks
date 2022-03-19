package com.example.restoranthesap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    Button addButton;
    TextView priceTxt,resultTxt;
    int b = 0;
    ListView listView;
    ArrayList <String> arrayList;
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.chooseSpin);
        addButton = findViewById(R.id.addButton);
        priceTxt = findViewById(R.id.priceTxt);
        resultTxt = findViewById(R.id.resultTxt);
        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        priceTxt.setText("2");
                        break;
                    case 1:
                        priceTxt.setText("5");
                        break;
                    case 2:
                        priceTxt.setText("3");
                        break;
                    case 3:
                        priceTxt.setText("4");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                a = Integer.parseInt(priceTxt.getText().toString());
                b = b + a;
                resultTxt.setText("Sum : " + b);

                arrayList.add(spin.getSelectedItem().toString());
                adapter.notifyDataSetChanged();
            }
        });

        addButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Hesabınız : " + b + " TL'dir.",Toast.LENGTH_LONG).show();
                return false;
            }
        });


    }
}
