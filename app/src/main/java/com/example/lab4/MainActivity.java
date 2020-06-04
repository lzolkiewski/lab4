package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[]values = new String[]{"example ex1", "example ex2", "example ex3"};
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(Arrays.asList(values));

        this.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.arrayList);

        ListView listView = (ListView)findViewById(R.id.exercisesListView);

        editListItem(listView);
        deleteListItem(listView);

        listView.setAdapter(this.adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String nowy = (String) extras.get("wpis");
            arrayList.add(nowy);
            adapter.notifyDataSetChanged();
        }
    }
//    przejdź do tworzenia nowego elementu
    public void newExercise(View view){
        startActivityForResult(new Intent(this, AddExercise.class), 1);
    }
//    edycja elementu listy
    public void editListItem(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = (TextView)view.findViewById(android.R.id.text1);

                String exerciseName = name.getText().toString();

                Intent intent = new Intent(getApplicationContext(), AddExercise.class);
                intent.putExtra("exerciseName", exerciseName);
                startActivityForResult(intent, 2);
            }
        });
    }
//    usunięcie elementu
    public void deleteListItem(ListView listView){
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id)
            {
                Toast.makeText(MainActivity.this, "LongClicked", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

}
