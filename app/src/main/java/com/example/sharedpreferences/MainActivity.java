package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName = findViewById(R.id.etName);
        final EditText etAge = findViewById(R.id.etAge);
        Button btSave = findViewById(R.id.btSave);
        Button btLoad = findViewById(R.id.btLoad);
        final TextView tvText = findViewById(R.id.tvText);

        final SharedPreferences sharedPreferences = getSharedPreferences("PreferencesName",MODE_PRIVATE);


        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name",etName.getText().toString());
                editor.putInt("Age",Integer.valueOf(etAge.getText().toString()));
                editor.apply();
            }
        });

        btLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setText(
                sharedPreferences.getString("Name","")+" ;"+
                sharedPreferences.getInt("Age",0)
                );
            }
        });
    }
}
