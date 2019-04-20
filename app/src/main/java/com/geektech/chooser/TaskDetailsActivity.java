package com.geektech.chooser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView tvTaskTitle, tvTaskDescription;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        tvTaskTitle = findViewById(R.id.tda_task_title);
        tvTaskDescription = findViewById(R.id.tda_task_description);
        Back = findViewById(R.id.goBack);


        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra("task");
        tvTaskTitle.setText(task.title);
        tvTaskDescription.setText(task.description);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TaskDetailsActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
