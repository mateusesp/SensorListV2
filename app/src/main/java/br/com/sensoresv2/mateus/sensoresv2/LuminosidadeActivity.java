package br.com.sensoresv2.mateus.sensoresv2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LuminosidadeActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView txvTexto;
    Sensor sensorLuminosidade;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luminosidade);

        linearLayout = findViewById(R.id.lnlBackgroundLuminosidade);
        txvTexto = findViewById(R.id.txvTextoLuminosidade);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorLuminosidade = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sensorManager.registerListener(new LuminosidadeListener(), sensorLuminosidade, SensorManager.SENSOR_DELAY_UI);
    }

    class LuminosidadeListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float valor1 = event.values[0];
            if (valor1 > 10) {
                txvTexto.setText(R.string.txv_luminosidade_claro);
                txvTexto.setTextColor(Color.BLACK);
                linearLayout.setBackgroundColor(Color.WHITE);
            } else {
                txvTexto.setText(R.string.txv_luminosidade_escuro);
                txvTexto.setTextColor(Color.WHITE);
                linearLayout.setBackgroundColor(Color.BLACK);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
