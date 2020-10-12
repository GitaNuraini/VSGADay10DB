package com.gita.vsgaday10db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button_tampil, button_simpan;
    EditText et_nama;
    DatabaseHelper databaseHelper;
    TextView txt_nama;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        txt_nama = findViewById(R.id.tvall);
        button_simpan = findViewById(R.id.btnsimpan);
        button_tampil = findViewById(R.id.btntampil);
        et_nama = findViewById(R.id.etnama);

        button_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_nama.getText())) {
                    Toast.makeText(MainActivity.this, "Harap inputkan nama", Toast.LENGTH_SHORT).show();
                }else {
                    databaseHelper.addStudentDetail(et_nama.getText().toString());
                    et_nama.setText("");
                    Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = databaseHelper.getAllStudentsList();
                txt_nama.setText("");
                for (int i = 0; i<arrayList.size(); i++){
                    txt_nama.setText(txt_nama.getText().toString()+", "+arrayList.get(i));
                }
            }
        });
    }
}