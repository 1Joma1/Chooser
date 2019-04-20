package com.geektech.chooser;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.geektech.chooser.R;
import com.geektech.chooser.MainAdapter;
import com.geektech.chooser.IOnTaskListener;
import com.geektech.chooser.Task;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements IOnTaskListener {

    RecyclerView recyclerView;
    Button addButton, randomButton;
    MainAdapter adapter;

    ArrayList<Task> data = new ArrayList<Task>(){{}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.mainAdd);
        randomButton = findViewById(R.id.Random);

        recyclerView = findViewById(R.id.recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(data, this);
        recyclerView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                intent.putExtra("id", data.size());
                startActivityForResult(intent, 1);
            }
        });
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.size() == 0){
                    Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_LONG).show();
                }
                else {
                    Random random = new Random();
                    int amount = random.nextInt(data.size());
                    Task task = data.get(amount);
                    Intent intent = new Intent(MainActivity.this, TaskDetailsActivity.class);
                    intent.putExtra("task", task);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            assert data != null;
            int id = data.getIntExtra("resId", 0);
            String title = data.getStringExtra("resTitle");
            String des = data.getStringExtra("resDes");
            MainActivity.this.data.add(new Task(id, title, des));
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onTaskClick(int id) {

    }
}
