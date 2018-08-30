package br.com.sensoresv2.mateus.sensoresv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListaSensores = findViewById(R.id.btnListaSensores);
        btnListaSensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaSensoresActivity.class);
                startActivity(intent);
            }
        });
        Button btnSensorProximidade = findViewById(R.id.btnSensorProximidade);
        btnSensorProximidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProximidadeActivity.class);
                startActivity(intent);
            }
        });
    }
}
