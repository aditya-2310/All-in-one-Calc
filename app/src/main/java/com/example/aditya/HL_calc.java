package com.example.aditya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HL_calc extends AppCompatActivity {

    public static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hl_calc);

        Button hcf = findViewById(R.id.HCF);
        Button lcm = findViewById(R.id.LCM);
        Button nextNo = findViewById(R.id.nextNo);
        Button clear_no = findViewById(R.id.clear_no);
        EditText no = findViewById(R.id.HLno);
        TextView result = findViewById(R.id.textView3);
        TextView input_no = findViewById(R.id.input_no);

        int[] arr = new int[]{-1, -1 , -1, -1 ,-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        nextNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arr[i] = nextInput(no);
                if (arr[i] != -1) {
                    input_no.setText(input_no.getText() + ", " + Integer.toString((arr[i])));
                    i++;
                }
                no.setText("");
            }
        });

        clear_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i != 0) {
                    i--;
                    arr[i] = -1;
                    input_no.setText("Numbers: ");
                    for (int j = 0; j < 15 && arr[j] != -1; j++) {
                        input_no.setText(input_no.getText() + ", " + Integer.toString(arr[j]));
                    }
                }
            }
        });

        hcf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("HCF is: " + hcf_lcm_calc(arr, "hcf"));
            }
        });

        lcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(("LCM is: " + hcf_lcm_calc(arr, "lcm")));
            }
        });
    }

    private int nextInput(EditText no){
        if (!no.getText().toString().isEmpty()) {
            return Integer.parseInt(no.getText().toString());
        }
        return -1;
    }

    private int hcf_lcm_calc(int[] arr, String check){
        int j = 1;
        int cur_hcf_lcm = arr[0];
        while (j < 15 && arr[j] != -1){
            int a = Math.max(cur_hcf_lcm, arr[j]), b = Math.min(cur_hcf_lcm, arr[j]);
            while(b > 0) {
                int c = a % b;
                a = b;
                b = c;
            }
            cur_hcf_lcm = check == "hcf" ? a : cur_hcf_lcm * arr[j] / a;
            j++;
        }
        return cur_hcf_lcm;
    }
}