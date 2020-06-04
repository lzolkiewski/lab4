package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class AddExercise extends AppCompatActivity {
    ArrayList<String> arrayList;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        ListView listView = (ListView)findViewById(R.id.seriesListView);
        arrayList = new ArrayList<>();
        if(arrayList.isEmpty()) {
            adapter = new ArrayAdapter<String>(this, R.layout.add_set_item, R.id.textView2, arrayList);
            listView.setAdapter(adapter);
        }

        ImageButton button = (ImageButton) findViewById(R.id.add_series);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "New series";
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });
    }
//    dodaj ćwiczenie
    public void wyslij(View view){
        EditText kontrolka = (EditText)findViewById(R.id.editTextExerciseName);
        String pole = kontrolka.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("wpis", pole);
        setResult(RESULT_OK, intent);

        finish();
    }
//    cofnij
    public void goBack(View view){
        finish();
    }
}
