package br.com.sensoresv2.mateus.sensoresv2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProximidadeActivity extends AppCompatActivity {

    TextView txvTextoProximidade;
    SensorManager sensorManager;
    Sensor sensorProximidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximidade);

        txvTextoProximidade = findViewById(R.id.txvTextoProximidade);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorProximidade = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(new ProximidadeListener(), sensorProximidade, SensorManager.SENSOR_DELAY_UI);
    }

    class ProximidadeListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float valor1 = event.values[0];
            if (valor1 > 10) {
                txvTextoProximidade.setText(R.string.txv_proximidade_longe);
            } else {
                txvTextoProximidade.setText(R.string.txv_proximidade_perto);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
