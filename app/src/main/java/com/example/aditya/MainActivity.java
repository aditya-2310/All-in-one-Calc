package com.example.aditya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button H_and_L = (Button) findViewById(R.id.HandL);

        H_and_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchtoHL();
            }
        });
    }

    public void switchtoHL(){
        Intent HL = new Intent(this, HL_calc.class);
        startActivity(HL);
    }
}