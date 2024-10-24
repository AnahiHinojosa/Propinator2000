package com.ahinojosa.propinator2000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private TextView text;
    private TextView number;
    private Button calc,del;
    private RadioGroup eleccion;
    private String precio = "";
    private Double total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView number = findViewById(R.id.numeros);
        Button calc = findViewById(R.id.calcular);
        Button del = findViewById(R.id.borrar);
        TextView text = findViewById(R.id.textprincipal);
        RadioGroup eleccion = findViewById(R.id.radios);
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
                findViewById(R.id.cero),
                findViewById(R.id.punto)
        };

        for (Button i:buttons) {
            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    precio += i.getText().toString();
                    number.setText(precio);
                }
            });

        }
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = eleccion.getCheckedRadioButtonId();
                RadioButton op = findViewById(id);
                String text1 = op.getText().toString();
                total = Double.parseDouble(number.getText().toString());
                double propina;

                switch (text1){
                    case "Mala" :
                        propina = total * 0.05;
                        text.setText("Total a pagar : " +(total + propina));
                        break;

                    case "Media" :
                        propina = total * 0.10;
                        text.setText("Total a pagar : " +(total + propina));
                        break;
                    case  "Buena" :
                        propina = total * 0.20;
                        text.setText("Total a pagar : " +(total + propina));
                        break;
                }

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                precio = "";
                number.setText(precio);
                number.setText(" ");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}