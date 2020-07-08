package com.annie.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);

        getSupportActionBar().setTitle("Edit item");
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etItem.setText("");
            }
        });

        // When user is doing editing
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent containing result
                Intent intent = new Intent();

                // pass the data (result of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // set the result of the intent
                setResult(RESULT_OK, intent);

                // finish activity, return to screen
                finish();
            }
        });
    }
}