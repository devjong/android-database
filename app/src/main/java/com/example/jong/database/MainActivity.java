package com.example.jong.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = editText.getText().toString();
                openDatabase(databaseName);
            }
        });


    }

    private void openDatabase(String databaseName) {
        println("openDatabase() 호출됨");

        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);

        if (database != null) {
            println("데이터베이스가 오픈됨");
        }
    }

    private void println(String data) {
        textView.append(data + "\n");
    }
}
