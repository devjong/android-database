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
    EditText editText2;
    TextView textView;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);

        // 데이터베이스 오픈
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = editText.getText().toString();
                openDatabase(databaseName);
            }
        });


        // 테이블 만들기
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tableName = editText2.getText().toString();
                createTable(tableName);
            }
        });


    }

    private void createTable(String tableName) {
        println("createTable() 호출됨.");

        if (database != null) {
            String sql = "create table "  + tableName + "(_id integer PRIMARY KEY autoincrement, name text, age integer, mobile text)";
            // 결과값을 받지 않아도 되는 sql문
            database.execSQL(sql);

            println("테이블 생성됨.");
        } else {
            println("먼저 데이터베이스를 오픈하세요.");
        }

    }

    // database가 연결이 되는 과정이 있어야 함
    // openDatabase는 앱을 실행할때마다 한 번씩 실행해줘야 함
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
