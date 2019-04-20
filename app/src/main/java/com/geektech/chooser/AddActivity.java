package com.geektech.chooser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd;
    EditText etTitle, etDes;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = findViewById(R.id.btnAdd);
        etTitle = findViewById(R.id.etTitle);
        etDes = findViewById(R.id.etDes);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        id = id+1;
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("resId", id);
            returnIntent.putExtra("resTitle", etTitle.getText().toString());
            returnIntent.putExtra("resDes", etDes.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
    }
}
