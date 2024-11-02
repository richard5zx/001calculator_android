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
    private Double result = 0.0;
    private Integer a, b;
    private EditText etA, etB;
    private TextView tvOper, tvResult;
    private Button[] btns = new Button[6];
    private int[] btnIds = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnCal, R.id.btnReset};

    // Setters & Getters
    public Double getResult() { return result; }
    public void setResult(Double result) { this.result = result; }
    public Integer getA() { return a; }
    public void setA(Integer a) { this.a = a; }
    public Integer getB() { return b; }
    public void setB(Integer b) { this.b = b; }

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

        // Check if there is input
        if(etA.length() == 0 || etA.length() == 0) { return; }

        int viewId = view.getId();

        String strA = etA.getText().toString();
        String strB = etB.getText().toString();
        Double a = Double.parseDouble(strA);
        Double b = Double.parseDouble(strB);
        double result = 0.0;

        if(viewId == btnIds[0]) {
            System.out.println("add");
            setResult(a + b);
            tvOper.setText("+");
        } else if (viewId == btnIds[1]) {
            System.out.println("min");
            setResult(a - b);
            tvOper.setText("-");
        } else if (viewId == btnIds[2]) {
            System.out.println("mul");
            tvOper.setText("*");
            setResult(a * b);
        } else if (viewId == btnIds[3]) {
            System.out.println("div");
            tvOper.setText("/");
            setResult(a / b);
        } else if (viewId == btnIds[4]) {
            System.out.println("equ");
            tvResult.setText(String.valueOf(getResult()));
        } else if (viewId == btnIds[5]) {
            System.out.println("clr");
            etA.setText("");
            etB.setText("");
            tvResult.setText(String.valueOf(0.0));
            setResult(0.0);
        } else {
            System.out.print("hi");
        }
    }
}