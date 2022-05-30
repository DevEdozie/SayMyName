package com.hfad.saymyname;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hfad.saymyname.databinding.ActivityMain2Binding;
import com.hfad.saymyname.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMain2Binding binding;
    ArrayList<String> nameHistory;
    String name;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        //arraylist
        nameHistory = new ArrayList<>();
        //TextView textView = (TextView) findViewById(R.id.user_name);
        //Button button = (Button) findViewById(R.id.button_2);
        //listener
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 name = binding.userName.getText().toString();
                 if(name != null){
                     text = "Hello " + name;
                     Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                     nameHistory.add(name);
                 }else{
                     Toast.makeText(MainActivity.this, "No input added\n Enter name", Toast.LENGTH_LONG).show();
                 }
                 /*
                 Commented this out to review what happens if the name 
                 isn't set to null
                  */
                //name = null;
            }
        });
        //fab
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 boolean Empty = nameHistory.isEmpty();
                 //if nameHistory is not empty
                    if(!Empty){
                        for(String item: nameHistory){
                            Toast.makeText(MainActivity.this, item+" Added", Toast.LENGTH_LONG).show();
                            //nameHistory.remove(item);
                        }
                        Toast.makeText(MainActivity.this, "All items added", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Nothing to be added!", Toast.LENGTH_SHORT).show();
                    }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Item Selection
        if(item.getItemId() == (R.id.history_menu)){
            Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
            intent.putStringArrayListExtra("history",nameHistory);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}