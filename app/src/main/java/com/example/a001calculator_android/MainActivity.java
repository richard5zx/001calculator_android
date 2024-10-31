package com.example.a001calculator_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Attributes
     private EditText etA, etB;
     private TextView tvOper, tvResult;
     private Button[] btns = new Button[6];
     private int[] btnIds = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnCal, R.id.btnReset};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
    }

    private void initView() {
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        tvOper = findViewById(R.id.tvOper);
        tvResult = findViewById(R.id.tvResult);
        for (int i = 0; i < btns.length; i++) {
            btns[i] = findViewById(btnIds[i]);
        }
    }

    public void onClick(View view) {
        int viewId = view.getId();

        if(viewId == btnIds[0]) {
            System.out.println("add");
            tvOper.setText("+");
        } else if (viewId == btnIds[1]) {
            System.out.println("min");
            tvOper.setText("-");
        } else if (viewId == btnIds[2]) {
            System.out.println("mul");
            tvOper.setText("*");
        } else if (viewId == btnIds[3]) {
            System.out.println("div");
            tvOper.setText("/");
        } else if (viewId == btnIds[4]) {
            System.out.println("equ");
        } else if (viewId == btnIds[5]) {
            System.out.println("clr");
        } else {
            System.out.print("hi");
        }
    }
}