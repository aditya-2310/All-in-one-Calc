package com.example.aditya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HL_calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hl_calc);

        Button hcf = findViewById(R.id.HCF);
        Button lcm = findViewById(R.id.LCM);
        EditText no1 = findViewById(R.id.HLno1);
        EditText no2 = findViewById(R.id.HLno2);
        TextView result = findViewById(R.id.textView3);

        hcf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(no1.getText().toString());
                int b = Integer.parseInt(no2.getText().toString());

                result.setText("HCF is: " + Integer.toString(hcf_calc(Math.max(a,b),Math.min(a,b))));
            }
        });

        lcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(no1.getText().toString());
                int b = Integer.parseInt(no2.getText().toString());

                result.setText("LCM is: " + Integer.toString(a*b / hcf_calc(Math.max(a,b),Math.min(a,b))));
            }
        });
    }
    private int hcf_calc(int c, int d){
        while (d != 0){
            int e = c%d;
            c = d;
            d = e;
        }
        return c;
    }
}