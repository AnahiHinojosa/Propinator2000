package com.ahinojosa.propinator2000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons;
    private RadioButton selecionado;
    private TextView text;
    private TextView number;
    private Button calc;
    private RadioGroup eleccion;
    private int precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RadioGroup eleccion = findViewById(R.id.radios);
        TextView number = findViewById(R.id.numeros);
        Button calc = findViewById(R.id.calcular);
        TextView text = findViewById(R.id.textprincipal);
        buttons = new Button[]{
                findViewById(R.id.uno),
                findViewById(R.id.dos),
                findViewById(R.id.tres),
                findViewById(R.id.cuatro),
                findViewById(R.id.cinco),
                findViewById(R.id.seis),
                findViewById(R.id.siete),
                findViewById(R.id.ocho),
                findViewById(R.id.nueve),
                findViewById(R.id.cero)
        };

        for (Button i:buttons) {
            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    precio+=i.getText().toString();
                    total_precio.
                }
            });

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}