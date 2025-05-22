package com.example.secuenciafibo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView TextVfibo;
    Button button1, button2;

    int currentIndex = 1;  // empieza desde 1
    HashMap<Integer, Integer> memo = new HashMap<>(); // memoization

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

        TextVfibo = findViewById(R.id.TexVfibo);
        button2 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button1);

        // Mostrar el primer valor
        TextVfibo.setText(String.valueOf(fibonacci(currentIndex)));

        button2.setOnClickListener(v -> {
            currentIndex++;
            TextVfibo.setText(String.valueOf(fibonacci(currentIndex)));
        });

        button1.setOnClickListener(v -> {
            if (currentIndex > 1) {
                currentIndex--;
                TextVfibo.setText(String.valueOf(fibonacci(currentIndex)));
            }
        });
    }

    // Fibonacci con memoization
    private int fibonacci(int n) {
        if (n <= 2) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

}