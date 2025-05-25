package com.example.calculadora_nueva;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Capturar EditText
    private EditText n1;
    private EditText n2;
    //Textview
    private TextView resultado;

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
        //relacion
        this.n1 = findViewById(R.id.txt1);
        this.n2 = findViewById(R.id.txt2);
        this.resultado = findViewById(R.id.txtresultado);

    }

    public void onClick(View view) {
        //Capturamos los eventos de la vista
        if (view.getId() == R.id.btn_suma) {
            resultado.setText("El resultado de la suma es: " + suma());
        } else if (view.getId() == R.id.btn_resta) {
            resultado.setText("El resultado de la resta es: " + resta());
        } else if (view.getId() == R.id.btn_multiplica) {
            resultado.setText("El resultado de la multiplicación es: " + multiplica());
        } else if (view.getId() == R.id.btn_divide) {
            resultado.setText("Ele resultado de la division es: " + divide());

        }
    }

    //Metodo sumar
    public double suma() {
        double resultado = 0;
        resultado = Double.parseDouble(this.n1.getText().toString().trim()) + Double.parseDouble(this.n2.getText().toString().trim());
        return resultado;

    }

    //Metodo resta
    public double resta() {
        double resultado = 0;
        resultado = Double.parseDouble(this.n1.getText().toString().trim()) - Double.parseDouble(this.n2.getText().toString().trim());
        return resultado;
    }

    //Metodo multipilica
    public double multiplica() {
        double resultado = 0;
        resultado = Double.parseDouble(this.n1.getText().toString().trim()) * Double.parseDouble(this.n2.getText().toString().trim());
        return resultado;

    }

    //Metodo Divide
    public double divide() {
        double resultado = 0;
        double numero1 = 0;
        double numero2 = 0;

        numero1 = Double.parseDouble(this.n1.getText().toString().trim());
        numero2 = Double.parseDouble(this.n2.getText().toString().trim());

        if (numero2 == 0) {
            Toast.makeText(this, "No es posible dividir un numero entre cero", Toast.LENGTH_LONG).show();
        } else {
            resultado = numero1 / numero2;
        }
        return resultado;
    }
}
