package com.hfad.saymyname;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hfad.saymyname.databinding.ActivityHistoryBinding;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<String> history;
    Toolbar toolbar;
    ActivityHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //toolbar = findViewById(R.id.history_toolbar);
        setSupportActionBar(binding.historyToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //view binding
        //binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        //View v = binding.getRoot();
        //setContentView(v);
        //getIntent
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            history = extras.getStringArrayList("history");
        }
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,history);
        //binding.nameHistory.setAdapter(listAdapter);
        //ListView listView = (ListView) findViewById(R.id.name_history);
        binding.nameHistory.setAdapter(listAdapter);
    }
}